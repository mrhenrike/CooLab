package Conexao;

//@author Márison Tamiarana

import Classes.Modelo_Usuario;
import static GUI_Frames.Tela_Principal.UserLogado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
 
public class Controle_Usuario {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    public boolean confirma_inserir = false;//Variavel para testar se o cadastro foi inserido com sucesso
    public boolean Confirma_Alterar= false;//Variavel para testar se o cadastro foi alterado com sucesso
    public boolean Confirma_Alterar_Senha= false;//Variavel para testar se a senha foi alterada com sucesso
    public boolean Confirma_Excluir= false;//Variavel para testar se o cadastro foi excluido com sucesso
    public boolean Confirma_Busca = false;//Variavel para testar se o cadastro foi encontrado com sucesso
    public boolean Confirma_Inativo = false;//Variavel para testar se o cadastro foi inativado com sucesso
    public boolean Confirma_Ativo = false;//Variavel para testar se o cadastro foi ativado com sucesso
    public boolean ControleExistente = false;//Variavel para testar se o usuario ja existe no sistema
    public boolean ControleAcesso = false;//Variavel para controlar o login
    public boolean ControleAcessoBloqueio = false;//Variavel para controlar o login na tela de bloqueio
    public boolean ControleAdm = false;//Variavel para verificar se ja existe um administrador
    public String Adm_Senha;
    public String Adm_Login;
    public int Adm_Id;
    
    public void Inserir_Usuario(Modelo_Usuario ObjUsu){
        ObjConecta.Conectar();
        
        String sql = "insert into usuario (situacao, nome, login, senha, telefone, data_cad_usuario, sexo, permissao)"
                + "values(?,?,?,?,?,?,?,?)";
                
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, "ATIVO");
                    stmt.setString(2, ObjUsu.getNome());
                    stmt.setString(3, ObjUsu.getLogin());
                    stmt.setString(4, ObjUsu.getSenha());
                    stmt.setString(5, ObjUsu.getTelefone());
                    stmt.setString(6, ObjUsu.getData_cad());
                    stmt.setString(7, ObjUsu.getSexo());
                    stmt.setString(8, ObjUsu.getPermissao());
                    
                }
                stmt.execute();
                stmt.close();
            }
           
           confirma_inserir = true;
           
        } catch (SQLException ex) {
            confirma_inserir=false;
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o usuario no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public void Alterar_Usuario(Modelo_Usuario ObjModeloUser, String id){
        ObjConecta.Conectar();
        
        String sql = "update usuario set nome=?, login=?, senha=?, telefone=?, sexo=?, permissao=?, situacao=?, data_ultima_alteracao_usuario=? "
                + " where id_usuario="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, ObjModeloUser.getNome());
                    stmt.setString(2, ObjModeloUser.getLogin());
                    stmt.setString(3, ObjModeloUser.getSenha());
                    stmt.setString(4, ObjModeloUser.getTelefone());
                    stmt.setString(5, ObjModeloUser.getSexo());
                    stmt.setString(6, ObjModeloUser.getPermissao());
                    stmt.setString(7, ObjModeloUser.getSituacao());
                    stmt.setString(8, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                }
                stmt.execute();
                stmt.close();
            }           
            Confirma_Alterar = true;          
           
        } catch (SQLException ex) {
            Confirma_Alterar = false;
            JOptionPane.showMessageDialog(null,"Erro ao alterar os dados do usuario no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public Modelo_Usuario Consulta_Usuario_Senha(Modelo_Usuario ObjModeloUser, String login) throws SQLException{
        try {
            ObjConecta.Conectar();

            String sql = "select * from usuario where login=" + "'" + login + "'" + "";

            try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery()) {

                rs.first();
                ObjModeloUser.setLogin(rs.getString("login"));
                ObjModeloUser.setSenha(rs.getString("senha"));
                ObjModeloUser.setId_usuario(rs.getInt("id_usuario"));

                ObjConecta.Desconecta();
                Confirma_Busca = true;
            }
        } catch (SQLException Erro) {            
            Confirma_Busca = false;
            ObjConecta.Desconecta();
        }

    return ObjModeloUser;

}
    
    public void Alterar_Senha_Usuario(Modelo_Usuario ObjModeloUser, Modelo_Usuario ObjModeloUser2)throws SQLException{
        try {
            ObjConecta.Conectar();
        
            String sql = "update usuario set senha=?, data_ultima_alteracao_usuario=? "
                    + " where login="+"'"+ObjModeloUser.getLogin()+"'"+" and senha="+"'"+ObjModeloUser.getSenha()+" '"+" ";
            
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, ObjModeloUser2.getSenha());
                    stmt.setString(2, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                }
                stmt.execute();
                stmt.close();
                Confirma_Alterar_Senha = true;
            } 
           
        } catch (SQLException ex) 
        {
            Confirma_Alterar_Senha = false;
            JOptionPane.showMessageDialog(null,"Erro ao alterar a senha do usuario no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
        }  
        
        ObjConecta.Desconecta();
    }
    
    public void Excluir_Usuario(String id){
        ObjConecta.Conectar();
        
        String sql = "delete from usuario where id_usuario="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.execute();
                stmt.close();
                Confirma_Excluir = true;
            }
        } catch (SQLException ex) 
            {
                Confirma_Excluir = false;
                JOptionPane.showMessageDialog(null,"Erro ao excluir os dados do usuario no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
    }
    
    public void Desativar_Usuario(String id){
        ObjConecta.Conectar();
        String sql = "update usuario set situacao=? where id_usuario="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,"INATIVO");
                stmt.execute();
                stmt.close();
                Confirma_Inativo = true;
            }
        } catch (SQLException ex) 
            {
                Confirma_Inativo = false;
                JOptionPane.showMessageDialog(null,"Erro ao Inativar os dados do usuario no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
        
    }
    
    public void Ativar_Usuario(String id){
        ObjConecta.Conectar();
        String sql = "update usuario set situacao=?, data_ultima_alteracao_usuario=? where id_usuario="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,"ATIVO");
                stmt.setString(2, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                stmt.execute();
                stmt.close();
                Confirma_Ativo = true;
            }
        } catch (SQLException ex) 
            {
                Confirma_Ativo = false;
                JOptionPane.showMessageDialog(null,"Erro ao Ativar os dados do usuario no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }  
        ObjConecta.Desconecta();
        
    }
    

public Modelo_Usuario Consulta_Usuario(Modelo_Usuario ObjModeloUser) throws SQLException{
      
        ObjConecta.Conectar();
        
        String sql = "select * from usuario where id_usuario=" +ObjModeloUser.getPesquisa()+"";
        try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql); 
             ResultSet rs = stm.executeQuery()) {
             
        rs.first();
      
            ObjModeloUser.setId_usuario(rs.getInt("id_usuario"));
            ObjModeloUser.setNome(rs.getString("nome"));
            ObjModeloUser.setSexo(rs.getString("sexo"));
            ObjModeloUser.setLogin(rs.getString("login"));
            ObjModeloUser.setSenha(rs.getString("senha"));
            ObjModeloUser.setPermissao(rs.getString("permissao"));
            ObjModeloUser.setTelefone(rs.getString("telefone"));
            ObjModeloUser.setSituacao(rs.getString("situacao"));
       
        ObjConecta.Desconecta();
   
    return ObjModeloUser;
    }
    }

 public void Testar_Existente(JTextField login){
        try {
            ObjConecta.Conectar();        
            ObjConecta.ExecutaSQL("Select * from usuario where login = '"+login.getText()+"'");        
            ObjConecta.rs.first(); 
            String Login = ObjConecta.rs.getString("login");
            ControleExistente = Login.equalsIgnoreCase(login.getText());
            
        } catch (SQLException ex) {
            ControleExistente=false;
            ObjConecta.Desconecta();            
        }
        ObjConecta.Desconecta();
    }
 
    public void Procura_Nome_Usuario(JLabel jl, String lg, JLabel jlcod){
        try {
            ObjConecta.Conectar();        
            ObjConecta.ExecutaSQL("Select * from usuario where login='"+lg+"' and situacao='ATIVO'" );        
            ObjConecta.rs.first();            

            jl.setText(ObjConecta.rs.getString("nome"));
            jlcod.setText(ObjConecta.rs.getString("id_usuario"));
            
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
        }
      ObjConecta.Desconecta();
    }
    
    public void Controle_Acesso(JTextField login, JComboBox permissao, JPasswordField senha){
        try {
            ObjConecta.Conectar();        
            ObjConecta.ExecutaSQL("Select * from usuario where permissao='"+permissao.getSelectedItem().toString()+"' "
                    + " and login = '"+login.getText()+"' and senha = '"+new String(senha.getPassword())+"'");        
            ObjConecta.rs.first(); 
            String Login = ObjConecta.rs.getString("login");
            ControleAcesso = Login.equalsIgnoreCase(login.getText());

        } catch (SQLException ex) {
            ControleAcesso=false;
            ObjConecta.Desconecta();
        }
        ObjConecta.Desconecta();
    }
    public void Controle_Acesso_Bloqueio(String user, JPasswordField jp){
        try {
            ObjConecta.Conectar();        
            ObjConecta.ExecutaSQL("Select * from usuario where nome ='"+user+"'");        
            ObjConecta.rs.first();       
            String Senha = ObjConecta.rs.getString("senha");
            ControleAcessoBloqueio = new String(jp.getPassword()).equals(Senha);           
        } catch (SQLException ex) {
            ControleAcessoBloqueio=false;
            
        }
    }
    //inserir o administrador do sistema
    public void Inserir_Admin(Modelo_Usuario ObjUsu){
    ObjConecta.Conectar();
        String sql = "insert into usuario (situacao, login, senha, data_cad_usuario, permissao)"
                + "values(?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, "ATIVO");
                    stmt.setString(2, ObjUsu.getLogin());
                    stmt.setString(3, ObjUsu.getSenha());
                    stmt.setString(4, ObjUsu.getData_cad());
                    stmt.setString(5, "SISTEMA");
                }
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o administrador no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }//fim do metodo
 
    public void Primeiro_Acesso(){
        try {
            ObjConecta.Conectar();        
            ObjConecta.ExecutaSQL("Select * from usuario where permissao = 'SISTEMA'");        
            ObjConecta.rs.first();            
            String Usuario = ObjConecta.rs.getString("login");
            ControleExistente = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ControleExistente=false; 
            ObjConecta.Desconecta();
        }
    }

public void Acesso_Adm(String permissao){
    try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from usuario where situacao = 'ATIVO' and permissao = '"+permissao+"'");        
        ObjConecta.rs.first();            
        Adm_Login = ObjConecta.rs.getString("login");
        Adm_Senha = ObjConecta.rs.getString("senha");
        Adm_Id = ObjConecta.rs.getInt("id_usuario");
        ControleAdm = true;
        ObjConecta.Desconecta();
        
    } catch (SQLException ex) {   
        ObjConecta.Desconecta();
        ControleAdm = false;
    }
}
public Modelo_Usuario Consulta_Usuario_Nome(Modelo_Usuario ObjModeloUser, int id_usuario){
    try {  
        ObjConecta.Conectar();        
        String sql = "select * from usuario where id_usuario=" +id_usuario+"";
        try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql); 
            ResultSet rs = stm.executeQuery()) {             
            rs.first();
            
            ObjModeloUser.setNome(rs.getString("nome"));
       
        ObjConecta.Desconecta();
        }
    } catch (SQLException ex) { }
    return ObjModeloUser;
    
    }

///////////////////////////Relatório/////////////////////////////////////////////
public void Relatorio_Usuario(String sql, String relat){
    String Org = "COOLAB - Coordenação de Laboratórios da Estácio | FCAT";
    try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_usuario) as cont from usuario where permissao !='SISTEMA' "+sql+"");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            
            ObjConecta.ExecutaSQL("select * from usuario where permissao !='SISTEMA' "+sql+" order by nome");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Tipo_Relatorio", relat);
            parametros.put("Organizacao",Org);
            String C = "C:\\Program Files (x86)\\SisCoE/Relat_Usuario.jasper";
            //String C = "/Relatorios/Relat_Produtos_Todos.jasper";
            JasperPrint JPrint = JasperFillManager.fillReport(C,parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Usuário");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
 
}