/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.constants;

/**
 * @author Vanderlei
 */
public interface BIBConstants {
	
	public static final int IDADE_MIN_CADASTRO = 10;
	public static final int LIMITE_EMPRESTIMO = 5;
	public static final int LIMITE_DIAS_EMPRESTIMO = 5;
	
	public static final int CODIGO_EXTRAVIO = 1;
	public static final int CODIGO_DANIFICADA = 2;
	
	
	public static final double VALOR_MULTA_DIARIO = 1.00;
	
	
	public static final String LOGO_BIB = "Biblioteca Central";
	
	public static final String MSG_ATRASO = "Referente à entrega com atraso de XX dia(s).";
	public static final String MSG_EXTRAVIO = "Referente ao extravio da obra citada acima.";
	
	public static final String MSG_TEXTO_1 = "O usuário poderá emprestar obras da Biblioteca após o pagamento da multa.";
	public static final String MSG_TEXTO_2 = "O pagamento deverá efetuado somente na bilioteca.";
	
	
	public static Object[] ITENS_MOTIVO = {"", "Extravio", "Danificada"};
	
	public static Object[] ITENS_GENERO = {"", "Romance", "Comédia", "Suspense", "Literatura", "Científica"};

}
