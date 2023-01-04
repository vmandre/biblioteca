/*
 * Criado em 27/06/2007
 *
 */
package pos.cefet.vma.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import pos.cefet.vma.component.IntPostgreSQL;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class BIBCreateTables {
	
	private static IntPostgreSQL intPostgreSQL = null;

	public static void populateTables() {
		try {
			FileReader fileReader = new FileReader("insert.bib");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			intPostgreSQL = new IntPostgreSQL();
			
			while (bufferedReader.ready()) {
				String linha = bufferedReader.readLine();
				
				intPostgreSQL.update(linha);
			}
			
		} catch (FileNotFoundException e) {
			BIBMessage.showError("Arquivo utilizado para o insert não foi encontrado!");
		} catch (IOException e) {
			BIBMessage.showError("Ocorreu um erro de leitura no Arquivo!");
		} catch (ClassNotFoundException e) {
			BIBMessage.showError(e.getMessage());
		} catch (SQLException e) {
			BIBMessage.showError(e.getMessage());
		}		
	}

	public static void createAndPopulateTables() {

		StringBuffer sql = new StringBuffer();

		sql.append("CREATE TABLE emprestimo_930652 (");
		sql.append("id_usuario integer NOT NULL,");
		sql.append("id_obra integer NOT NULL,");
		sql.append("data_emprestimo timestamp with time zone NOT NULL,");
		sql.append("data_devolucao timestamp with time zone");
		sql.append(");");
		sql.append("ALTER TABLE public.emprestimo_930652 OWNER TO aval_user;");

		sql.append("CREATE TABLE genero_930652 (");
		sql.append("id integer NOT NULL,");
		sql.append("descricao character(100)");
		sql.append(");");
		sql.append("ALTER TABLE public.genero_930652 OWNER TO aval_user;");

		sql.append("CREATE TABLE motivo_desativacao_930652 (");
		sql.append("id integer NOT NULL,");
		sql.append("descricao character(100) NOT NULL");
		sql.append(");");
		sql.append("ALTER TABLE public.motivo_desativacao_930652 OWNER TO aval_user;");

		sql.append("CREATE TABLE multa_930652 (");
		sql.append("data_emissao timestamp with time zone NOT NULL,");
		sql.append("id_obra integer NOT NULL,");
		sql.append("id_usuario integer NOT NULL,");
		sql.append("data_pagamento timestamp with time zone,");
		sql.append("valor real,");
		sql.append("motivo character(1) NOT NULL,");
		sql.append("dias_atraso integer DEFAULT 0 NOT NULL,");
		sql.append("id_multa bigint DEFAULT 0 NOT NULL");
		sql.append(");");
		sql.append("ALTER TABLE public.multa_930652 OWNER TO aval_user;");
		
		sql.append("CREATE TABLE obra_930652 (");
		sql.append("id integer NOT NULL,");
		sql.append("descricao character(100),");
		sql.append("genero integer,");
		sql.append("autor character(100),");
		sql.append("editora character(100),");
		sql.append("data_publicacao timestamp with time zone,");
		sql.append("data_ativacao timestamp with time zone,");
		sql.append("data_desativacao timestamp with time zone,");
		sql.append("motivo_desativacao integer,");
		sql.append("status character(1),");
		sql.append("valor real");
		sql.append(");");
		sql.append("ALTER TABLE public.obra_930652 OWNER TO aval_user;");
		
		sql.append("CREATE TABLE usuario_930652 (");
		sql.append("id integer NOT NULL,");
		sql.append("pwd character(60) NOT NULL,");
		sql.append("nome character(100),");
		sql.append("cpf bigint,");
		sql.append("ddd integer,");
		sql.append("telefone_contato integer,");
		sql.append("telefone_celular integer,");
		sql.append("telefone_comercial integer,");
		sql.append("email character(100),");
		sql.append("data_nasc timestamp with time zone,");
		sql.append("status character(1) ");
		sql.append(");");

		sql.append("ALTER TABLE public.usuario_930652 OWNER TO aval_user;");
		sql.append("ALTER TABLE ONLY emprestimo_930652 ");
		sql.append("ADD CONSTRAINT EMPRESTIMO_PK PRIMARY KEY (id_usuario, id_obra, data_emprestimo);");		
		sql.append("ALTER TABLE ONLY genero_930652");
		sql.append(" ADD CONSTRAINT GENERO_PK PRIMARY KEY (id);");
		sql.append("ALTER TABLE ONLY motivo_desativacao_930652");
		sql.append(" ADD CONSTRAINT MOT_DESATIVACAO_PK PRIMARY KEY (id);");
		sql.append("ALTER TABLE ONLY obra_930652");
		sql.append(" ADD CONSTRAINT OBRA_PK PRIMARY KEY (id);");
		sql.append("ALTER TABLE ONLY usuario_930652");
		sql.append(" ADD CONSTRAINT USUARIO_PK PRIMARY KEY (id);");
		sql.append("ALTER TABLE ONLY multa_930652");
		sql.append(" ADD CONSTRAINT multa_930652_pkey PRIMARY KEY (data_emissao, id_obra, id_usuario);");
		sql.append("CREATE INDEX \"fki_OBRA_DESATIVACAO\" ON obra_930652 USING btree (motivo_desativacao);");
		sql.append("CREATE INDEX \"fki_OBRA_GENERO\" ON obra_930652 USING btree (genero);");
		sql.append("ALTER TABLE ONLY emprestimo_930652");
		sql.append(" ADD CONSTRAINT \"EMPRESTIMO_OBRA\" FOREIGN KEY (id_obra) REFERENCES obra_930652(id);");
		sql.append("ALTER TABLE ONLY emprestimo_930652");
		sql.append(" ADD CONSTRAINT \"EMPRESTIMO_USUARIO\" FOREIGN KEY (id_usuario) REFERENCES usuario_930652(id);");
		sql.append("ALTER TABLE ONLY obra_930652");
		sql.append(" ADD CONSTRAINT \"OBRA_DESATIVACAO\" FOREIGN KEY (motivo_desativacao) REFERENCES motivo_desativacao_930652(id);");
		sql.append("ALTER TABLE ONLY obra_930652");
		sql.append(" ADD CONSTRAINT \"OBRA_GENERO\" FOREIGN KEY (genero) REFERENCES genero_930652(id);");

		sql.append("CREATE TABLE endereco_930652 (");
		sql.append("cep integer NOT NULL,");
		sql.append("logradouro character(100) NOT NULL,");
		sql.append("numero integer NOT NULL,");
		sql.append("complemento character(60) NOT NULL,");
		sql.append("bairro character(60) NOT NULL,");
		sql.append("cidade character(100) NOT NULL,");
		sql.append("uf character(2) NOT NULL,");
		sql.append("id integer NOT NULL REFERENCES usuario_930652 ON DELETE CASCADE,");
		sql.append("CONSTRAINT endereco_pk PRIMARY KEY (id),");
		sql.append("CONSTRAINT \"ENDERECO_USUARIO\" FOREIGN KEY (id)");
		sql.append(" REFERENCES usuario_930652 (id) MATCH SIMPLE");
		sql.append(" ON UPDATE NO ACTION ON DELETE NO ACTION	)"); 
		sql.append(" WITHOUT OIDS;");
		sql.append(" ALTER TABLE endereco_930652 OWNER TO aval_user;");
		sql.append(" DROP INDEX IF EXISTS \"fki_ENDERECO_USUARIO\";");
		sql.append(" CREATE INDEX \"fki_ENDERECO_USUARIO\"");
		sql.append(" ON endereco_930652");
		sql.append(" USING btree");
		sql.append(" (id);");

		sql.append("INSERT INTO genero_930652 (id, descricao) VALUES (3, 'Suspense');");
		sql.append("INSERT INTO genero_930652 (id, descricao) VALUES (1, 'Romance');");
		sql.append("INSERT INTO genero_930652 (id, descricao) VALUES (2, 'Comedia');");
		sql.append("INSERT INTO genero_930652 (id, descricao) VALUES (4, 'Literatura');");
		sql.append("INSERT INTO genero_930652 (id, descricao) VALUES (5, 'Cientifica');");

		sql.append("INSERT INTO motivo_desativacao_930652 (id, descricao) VALUES (1, 'Extravio');");
		sql.append("INSERT INTO motivo_desativacao_930652 (id, descricao) VALUES (2, 'Danificada');");
				
		try {
			intPostgreSQL = new IntPostgreSQL();			
			intPostgreSQL.update(sql.toString());			
			BIBMessage.showInfo("Base de Dados criada!");	

//			int resp = JOptionPane.showConfirmDialog(null, "Deseja inserir dados na Base de Dados?", "Inserir Dados ?", JOptionPane.YES_NO_OPTION);
			
//			if (resp == 0) {
//				populateTables();	 
//			}			
					
		} catch (ClassNotFoundException e) {
			BIBMessage.showError(e);
		} catch (SQLException e) {
			BIBMessage.showError(e.getMessage());
		}
	}
}
