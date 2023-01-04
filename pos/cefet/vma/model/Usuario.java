/*
 * Criado em 22/06/2007
 *
 */
package pos.cefet.vma.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pos.cefet.vma.component.IntPostgreSQL;
import pos.cefet.vma.constants.BIBConstants;
import pos.cefet.vma.interfaces.InterfaceUsuario;
import pos.cefet.vma.view.IntUsuarioAlteracao;
import pos.cefet.vma.view.IntUsuarioInclusao;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class Usuario {
	
	private int id;
	private String pwd;
	private long cpf;
	private String nome;
	private Date dataNascimento;
	private int ddd;
	private int telContato;
	private int telCelular;
	private int telComercial;
	private String email;
	private Endereco endereco;
	private String status;
	
	private IntPostgreSQL postgreSQL;
	
	public Usuario() {
	}
	
	public Usuario(int id, String pwd) {
		this.setId(id);
		this.setPwd(pwd);
	}

	public Usuario(int id, long cpf, String nome, String senha, Date dataNasc, 
		String email, int numDDD, int numTelCont, int numTelCel, int numTelCom, String status) {
		
		this.setId(id);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setPwd(senha);
		this.setDataNascimento(dataNasc);
		this.setEmail(email);
		this.setDdd(numDDD);
		this.setTelContato(numTelCont);
		this.setTelCelular(numTelCel);
		this.setTelComercial(numTelCom);
		this.setStatus(status);
	}

	
	public Usuario(int id, long cpf, String nome, String senha, Date dataNasc, 
	String logradouro, int numero, String bairro, String complemento, String email, 
	String cidade, String uf, int numCep, int numDDD, int numTelCont, int numTelCel, int numTelCom, String status) {
		
		this.setId(id);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setPwd(senha);
		this.setDataNascimento(dataNasc);
		this.setEndereco(new Endereco(id, logradouro, numero, bairro, complemento, cidade, numCep, uf));
		this.setEmail(email);
		this.setDdd(numDDD);
		this.setTelContato(numTelCont);
		this.setTelCelular(numTelCel);
		this.setTelComercial(numTelCom);
		this.setStatus(status);
	}
	
	public static Object validarDadosUsuario(Object intUsuario) {
		
		InterfaceUsuario interfaceUsuario = null;
		
		if (intUsuario instanceof IntUsuarioAlteracao) {
			interfaceUsuario = (IntUsuarioAlteracao)intUsuario;
		} else if (intUsuario instanceof IntUsuarioInclusao) {
			interfaceUsuario = (IntUsuarioInclusao)intUsuario;
		} 
		
		int id;
		try {
			id = Integer.parseInt(interfaceUsuario.getTxtMatricula().getText());
		}catch(NumberFormatException nfe){return "Matrícula inválida!";}

		long cpf;
		try {
			cpf = Long.parseLong(interfaceUsuario.getTxtCPF().getText());
		}catch(NumberFormatException nfe){return "CPF  inválido!";}
		
		String nome = interfaceUsuario.getTxtNome().getText();
		if (nome.equals("")) return "O nome deve ser preenchido!";
		
		String senha1 = new String(interfaceUsuario.getTxtSenha1().getPassword());
		String senha2 = new String(interfaceUsuario.getTxtSenha2().getPassword());
		if (senha1.equals("")) return "A senha deve ser preenchida!";
		if (senha2.equals("")) return "O campo confirmar senha deve ser preenchido!";

		if (! senha1.equals(senha2))
			return "Senhas não conferem!";
		
		if (interfaceUsuario.getTxtDataNasc().getText().equals("")) return "Data de nascimento deve ser preenchida!";
		if (interfaceUsuario.getTxtDataNasc().getText().indexOf("/") == -1) return "Data com formato inválido! \nDeve ser preenchida no formato dd/mm/aaaa";
		Calendar calendar = Calendar.getInstance();
		String dia = "";
		String mes = "";
		String ano = "";
		try {
			dia = interfaceUsuario.getTxtDataNasc().getText().substring(0, 2);
			mes = interfaceUsuario.getTxtDataNasc().getText().substring(3, 5);
			ano = interfaceUsuario.getTxtDataNasc().getText().substring(6);
		} catch (RuntimeException e) {
			return "Data com formato inválido!";
		}
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));
		calendar.set(Calendar.MONTH, Integer.parseInt(mes)-1);
		calendar.set(Calendar.YEAR, Integer.parseInt(ano) + BIBConstants.IDADE_MIN_CADASTRO);
		
		Calendar dataNasc = Calendar.getInstance();
		dataNasc.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));
		dataNasc.set(Calendar.MONTH, Integer.parseInt(mes)-1);
		dataNasc.set(Calendar.YEAR, Integer.parseInt(ano));
		dataNasc.set(Calendar.HOUR_OF_DAY, 0);
		dataNasc.set(Calendar.MINUTE, 0);
		dataNasc.set(Calendar.SECOND, 0);
		
		Date dataAtual = Calendar.getInstance().getTime();		
		if (dataAtual.before(calendar.getTime())) {return "Data de nascimento inválida!";}
		
		String logradouro = interfaceUsuario.getTxtLogradouro().getText();
		int numero;
		try {
			numero = Integer.parseInt(interfaceUsuario.getTxtNumero().getText());
		} catch (NumberFormatException nfe) {numero = 0;}
		
		String bairro = interfaceUsuario.getTxtBairro().getText();
		String complemento = interfaceUsuario.getTxtComplemento().getText();
		
		String email = interfaceUsuario.getTxtEmail().getText();
		if (email.indexOf('@') == -1 || email.indexOf('.') == -1) {
			return "Formato do e-mail inválido!";
		}
		
		String cidade = interfaceUsuario.getTxtCidade().getText();
		String uf = interfaceUsuario.getTxtUF().getText();

		String cep = interfaceUsuario.getTxtCEP().getText();
		int numCep;
		if (cep.equals("")) numCep = 0;

		try {
			numCep = Integer.parseInt(cep);
		}catch(NumberFormatException nfe){return "CEP inválido!";}
		
		String ddd = interfaceUsuario.getTxtDDD().getText();
		int numDDD;
		if (ddd.equals("")) numDDD = 0;
		try {
			numDDD = Integer.parseInt(ddd);
		}catch(NumberFormatException nfe){return "DDD inválido!";}
		
		String telCont = interfaceUsuario.getTxtTelCont().getText();
		int numTelCont;
		if (telCont.equals("")) numTelCont = 0;
		try {
			numTelCont = Integer.parseInt(telCont);
		}catch(NumberFormatException nfe){return "Telefone p/ contato inválido!";}
		
		String telCel = interfaceUsuario.getTxtTelCel().getText();
		int numTelCel;
		if (telCel.equals("")) numTelCel = 0;
		try {
			numTelCel = Integer.parseInt(telCel);
		}catch(NumberFormatException nfe){return "Telefone celular inválido!";}
		
		String telCom = interfaceUsuario.getTxtTelCom().getText();
		int numTelCom;
		if (telCom.equals("")) numTelCom = 0;
		try {
			numTelCom = Integer.parseInt(telCom);
		}catch(NumberFormatException nfe){return "Telefone comercial inválido!";}
		
		String status2;
		if (interfaceUsuario.getJChkAtivo().isSelected()){
			status2 = "A";
		} else {
			status2 = "I";
		}
		
		return new Usuario(id, cpf, nome, senha1, dataNasc.getTime(), logradouro, numero, bairro, complemento, email, cidade, uf, numCep, numDDD, numTelCont, numTelCel, numTelCom, status2);
	}
	
	public Usuario createUsuario(int id, String pwd) {
		return new Usuario(id, pwd);
	}
	
	public Usuario createUsuario(int id, long cpf, String nome, String senha, Date dataNasc, 
		String logradouro, int numero, String bairro, String complemento, String email, 
		String cidade, String uf, int numCep, int numDDD, int numTelCont, int numTelCel, int numTelCom) {

		return new Usuario(id, pwd);
	}
	
	public Usuario createUsuario(int id, long cpf, String nome, String senha, Date dataNasc, 
		String email, int numDDD, int numTelCont, int numTelCel, int numTelCom, String status) {

		return new Usuario(id, cpf, nome, senha, dataNasc, 
			email, numDDD, numTelCont, numTelCel, numTelCom, status);
	}
	
	public void inserir() throws ClassNotFoundException, SQLException {		
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO usuario_930652 ");
		sql.append("(id, pwd, nome, cpf, ddd, telefone_contato, telefone_celular, telefone_comercial, email, data_nasc, status) ");
		sql.append("VALUES (");
		sql.append(this.getId());
		sql.append(", ");
		sql.append("'");
		sql.append(this.getPwd());
		sql.append("'");
		sql.append(", ");
		sql.append("'");
		sql.append(this.getNome());
		sql.append("'");
		sql.append(", ");
		sql.append(this.getCpf());
		sql.append(", ");
		sql.append(this.getDdd());
		sql.append(", ");
		sql.append(this.getTelContato());
		sql.append(", ");
		sql.append(this.getTelCelular());
		sql.append(", ");
		sql.append(this.getTelComercial());
		sql.append(", ");
		sql.append("'");
		sql.append(this.getEmail());
		sql.append("'");
		sql.append(", ");
		sql.append("'");
	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getDataNascimento());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append(dateFormat.format(calendar.getTime()));
		sql.append("'");
		sql.append(", ");
		sql.append("'");
		sql.append(String.valueOf(this.getStatus()));
		sql.append("'");
		
		sql.append(")");
		
		postgreSQL.insert(sql.toString());		
	}
	
	public void excluir() throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();
		
		//Se existir um endereço cadastrado para o usuário, será excluído da Base de Dados.
//		Endereco endereco = new Endereco();
//		if (endereco.getEnderecoByUsuario(this.getId()) != null) {
//			endereco.setIdUsuario(this.getId());
//			endereco.excluir();
//		}
		
		StringBuffer sql = new StringBuffer();
//		sql.append("DELETE FROM usuario_930652 ");
//		sql.append(" WHERE id = ");
//		sql.append(this.getId());

		sql.append("UPDATE usuario_930652 SET status = 'I'");
		sql.append(" WHERE id = ");
		sql.append(this.getId());

		postgreSQL.update(sql.toString());
	}
	
	public void desativar() throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE usuario_930652 SET status = 'I'");
		sql.append(" WHERE id = ");
		sql.append(this.getId());

		postgreSQL.update(sql.toString());
	}
	
	public void alterar() throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE usuario_930652 SET ");
		sql.append("pwd = ");
		sql.append("'");
		sql.append(this.getPwd());
		sql.append("'");
		sql.append(", ");
		sql.append("nome = ");
		sql.append("'");
		sql.append(this.getNome());
		sql.append("'");
		sql.append(", ");
		sql.append("cpf = ");
		sql.append(this.getCpf());
		sql.append(", ");
		sql.append("ddd = ");
		sql.append(this.getDdd());
		sql.append(", ");
		sql.append("telefone_contato = ");
		sql.append(this.getTelContato());
		sql.append(", ");
		sql.append("telefone_celular = ");
		sql.append(this.getTelCelular());
		sql.append(", ");
		sql.append("telefone_comercial = ");
		sql.append(this.getTelComercial());
		sql.append(", ");
		sql.append("email = ");
		sql.append("'");
		sql.append(this.getEmail());
		sql.append("'");
		sql.append(", ");
		sql.append("data_nasc = ");
		sql.append("'");		
	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getDataNascimento());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append(dateFormat.format(calendar.getTime()));
		sql.append("'");
		sql.append(", ");
		sql.append("status = ");
		sql.append("'");
		sql.append(this.getStatus());
		sql.append("'");
		sql.append(" WHERE id = ");
		sql.append(this.getId());
		
		postgreSQL.update(sql.toString());		
	}
	
	public Usuario getUsuario() {
		return null;
	}
	
	public Usuario getUsuarioById(int id) throws ClassNotFoundException, SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM usuario_930652 WHERE id = " );
		sql.append(id);
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {

			int id2 = resultSet.getInt("id");
			String pwd2 = resultSet.getString("pwd");
			String nome = resultSet.getString("nome");
			long cpf = resultSet.getLong("cpf");
			int ddd = resultSet.getInt("ddd");
			int telContato = resultSet.getInt("telefone_contato");
			int telCelular = resultSet.getInt("telefone_celular");
			int telComercial = resultSet.getInt("telefone_comercial");
			String email = resultSet.getString("email");
			Date dtNasc = resultSet.getDate("data_nasc");
			String status2 = resultSet.getString("status");
			
			return this.createUsuario(id2, cpf, nome, pwd2, dtNasc, email, ddd, telContato, telCelular, telComercial, status2);
		}		
		return null;
	}
	
	public Usuario getUsuarioByCpf(long cpf) throws ClassNotFoundException, SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM usuario_930652 WHERE cpf = " );
		sql.append(cpf);
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {

			int id = resultSet.getInt("id");
			String pwd = resultSet.getString("pwd");
			String nome = resultSet.getString("nome");
			long cpf2 = resultSet.getLong("cpf");
			int ddd = resultSet.getInt("ddd");
			int telContato = resultSet.getInt("telefone_contato");
			int telCelular = resultSet.getInt("telefone_celular");
			int telComercial = resultSet.getInt("telefone_comercial");
			String email = resultSet.getString("email");
			Date dtNasc = resultSet.getDate("data_nasc");
			String status = resultSet.getString("status");
			
			return this.createUsuario(id, cpf2, nome, pwd, dtNasc, email, ddd, telContato, telCelular, telComercial, status);
		}		
		return null;
	}	
	
	public Usuario getUsuarioByIdAndPwd(int id, String pwd) throws ClassNotFoundException, SQLException {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM usuario_930652 WHERE id = " );
		sql.append(id);
		sql.append(" and pwd = '");
		sql.append(pwd);
		sql.append("'");
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {
			int id2 = resultSet.getInt("id");
			String pwd2 = resultSet.getString("pwd");
			
			return this.createUsuario(id2, pwd2);
		}
	
		return null;
	}
		
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @param string
	 */
	public void setPwd(String string) {
		pwd = string;
	}

	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param string
	 */
	public void setNome(String string) {
		nome = string;
	}

	/**
	 * @return
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param date
	 */
	public void setDataNascimento(Date date) {
		dataNascimento = date;
	}

	/**
	 * @return
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return
	 */
	public long getCpf() {
		return cpf;
	}

	/**
	 * @param l
	 */
	public void setCpf(long l) {
		cpf = l;
	}

	/**
	 * @return
	 */
	public int getDdd() {
		return ddd;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public int getTelCelular() {
		return telCelular;
	}

	/**
	 * @return
	 */
	public int getTelComercial() {
		return telComercial;
	}

	/**
	 * @return
	 */
	public int getTelContato() {
		return telContato;
	}

	/**
	 * @param i
	 */
	public void setDdd(int i) {
		ddd = i;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param i
	 */
	public void setTelCelular(int i) {
		telCelular = i;
	}

	/**
	 * @param i
	 */
	public void setTelComercial(int i) {
		telComercial = i;
	}

	/**
	 * @param i
	 */
	public void setTelContato(int i) {
		telContato = i;
	}
	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param c
	 */
	public void setStatus(String c) {
		status = c;
	}

}
