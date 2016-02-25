package GUI_Frames;

//@author Márison Tamiarana

import Classes.Modelo_Categoria;
import Classes.Modelo_Tabela;
import Conexao.Conecta_Banco;
import Conexao.Controle_Categoria;
import GUI_Dialogs_Categoria.Conf_Alterar_Categoria1;
import GUI_Dialogs_Categoria.Conf_Cancelar_Categ1;
import GUI_Dialogs_Categoria.Conf_Sair_Sem_Salvar_Categ1;
import GUI_Dialogs_Categoria.Conf_Salvar_Categoria1;
import GUI_Dialogs_Categoria.Inf_Cadastro_Existente_Categ1;
import GUI_Dialogs_Categoria.Inf_Dados_Alterados_Categ1;
import GUI_Dialogs_Categoria.Inf_Dados_Nao_Alterados_Categ1;
import GUI_Dialogs_Categoria.Inf_Dados_Nao_Salvos_Categ1;
import GUI_Dialogs_Categoria.Inf_Dados_Salvos_Categ1;
import GUI_Dialogs_Categoria.Inf_Preencher_Campos_Categ1;
import Metodos.Formatacao;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class Tela_Cadastro_Categoria_DL1 extends javax.swing.JDialog {
    
    Tela_Cadastro_Prod_Edit ObjCadProd = new Tela_Cadastro_Prod_Edit();
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Controle_Categoria ObjControlCategoria = new Controle_Categoria();
    Modelo_Categoria ObjModCategoria = new Modelo_Categoria();
    Formatacao ObjFormat = new Formatacao();
    
    public boolean ControleSalvar = false;
    public boolean ControleExistente = false;
    
    private static Inf_Dados_Salvos_Categ1 ObjDadosSalvos;
    private static Inf_Preencher_Campos_Categ1 ObjPreencherCampos;
    private static Inf_Dados_Alterados_Categ1 ObjDadosAlterados;
    private static Inf_Dados_Nao_Salvos_Categ1 ObjDadosNaoSalvos;
    private static Inf_Dados_Nao_Alterados_Categ1 ObjDadosNaoAlterados;
    private static Inf_Cadastro_Existente_Categ1 ObjCadastroExiste;
    private static Conf_Salvar_Categoria1 ObjConfSalvar;
    private static Conf_Alterar_Categoria1 ObjConfAlterar;
    private static Conf_Cancelar_Categ1 ObjCancelarAlterar;
    private static Conf_Sair_Sem_Salvar_Categ1 ObjSairSemSalvar;
    
    

    public Tela_Cadastro_Categoria_DL1(Tela_Cadastro_Prod_Edit parent, boolean modal) {
        this.ObjCadProd = parent;
        this.setModal(modal);
        
        initComponents();
        setResizable(false);
        setSize(725,470);
        setLocationRelativeTo(ObjCadProd);
        Preencher_Tabela_Categoria("select * from categoria_produto order by categoria");
        JRB_Ativo.setSelected(true);
        BT_Cancelar.setEnabled(false);
        BT_Editar.setEnabled(false);       
        Desabilita_Alterar();
        JTF_Categoria.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Desc_Alterar.setDocument(ObjFormat.new Format_Geral(100));
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_Situacao = new javax.swing.ButtonGroup();
        JP_Categoria = new javax.swing.JPanel();
        JL_Descricao = new javax.swing.JLabel();
        JTF_Categoria = new javax.swing.JTextField();
        JP_Organizar = new javax.swing.JPanel();
        JRB_Ativo = new javax.swing.JRadioButton();
        JRB_Inativo = new javax.swing.JRadioButton();
        JRB_Todos = new javax.swing.JRadioButton();
        JP_TB_Categoria = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Categoria = new javax.swing.JTable();
        BT_Salvar = new javax.swing.JButton();
        BT_Editar = new javax.swing.JButton();
        BT_Cancelar = new javax.swing.JButton();
        BT_Sair = new javax.swing.JButton();
        JP_Alterar_Dados = new javax.swing.JPanel();
        JL_Cod = new javax.swing.JLabel();
        JTF_Cod = new javax.swing.JTextField();
        JL_Desc_Alterar = new javax.swing.JLabel();
        JTF_Desc_Alterar = new javax.swing.JTextField();
        JL_Situacao = new javax.swing.JLabel();
        JCB_Situacao = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro De Categoria");
        setUndecorated(true);

        JP_Categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Nova Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JL_Descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Descricao.setText("Descrição*:");

        JTF_Categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JP_CategoriaLayout = new javax.swing.GroupLayout(JP_Categoria);
        JP_Categoria.setLayout(JP_CategoriaLayout);
        JP_CategoriaLayout.setHorizontalGroup(
            JP_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_Descricao)
                .addGap(18, 18, 18)
                .addComponent(JTF_Categoria)
                .addContainerGap())
        );
        JP_CategoriaLayout.setVerticalGroup(
            JP_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CategoriaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(JP_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Descricao)
                    .addComponent(JTF_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JP_Organizar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Organizar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        BG_Situacao.add(JRB_Ativo);
        JRB_Ativo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Ativo.setText("Ativo");
        JRB_Ativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_AtivoActionPerformed(evt);
            }
        });

        BG_Situacao.add(JRB_Inativo);
        JRB_Inativo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Inativo.setText("Inativo");
        JRB_Inativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_InativoActionPerformed(evt);
            }
        });

        BG_Situacao.add(JRB_Todos);
        JRB_Todos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Todos.setText("Todos");
        JRB_Todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_TodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_OrganizarLayout = new javax.swing.GroupLayout(JP_Organizar);
        JP_Organizar.setLayout(JP_OrganizarLayout);
        JP_OrganizarLayout.setHorizontalGroup(
            JP_OrganizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_OrganizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_OrganizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JRB_Ativo)
                    .addComponent(JRB_Inativo)
                    .addComponent(JRB_Todos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_OrganizarLayout.setVerticalGroup(
            JP_OrganizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_OrganizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JRB_Ativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JRB_Inativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JRB_Todos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JP_TB_Categoria.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTB_Categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Categoria.setToolTipText("Selecione Uma Linha, Clique Duas Vezes Pra Editar Ou Clique No Botão Editar (Ou Precione Alt + E)");
        JTB_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_CategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Categoria);

        javax.swing.GroupLayout JP_TB_CategoriaLayout = new javax.swing.GroupLayout(JP_TB_Categoria);
        JP_TB_Categoria.setLayout(JP_TB_CategoriaLayout);
        JP_TB_CategoriaLayout.setHorizontalGroup(
            JP_TB_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_TB_CategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        JP_TB_CategoriaLayout.setVerticalGroup(
            JP_TB_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_TB_CategoriaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
            }
        });

        BT_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar.png"))); // NOI18N
        BT_Editar.setMnemonic('e');
        BT_Editar.setToolTipText("Selecione Uma Linha E Clique Para Editar Ou Pressione Alt + E");
        BT_Editar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar press.png"))); // NOI18N
        BT_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_EditarActionPerformed(evt);
            }
        });

        BT_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar.png"))); // NOI18N
        BT_Cancelar.setMnemonic('c');
        BT_Cancelar.setToolTipText("Clique Para Cancelar A Edição Ou Pressione Alt + C");
        BT_Cancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar Press.png"))); // NOI18N
        BT_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CancelarActionPerformed(evt);
            }
        });

        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair.png"))); // NOI18N
        BT_Sair.setMnemonic('r');
        BT_Sair.setToolTipText("Clique Para Sair Ou Pressione Alt + R");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair press.png"))); // NOI18N
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
            }
        });

        JP_Alterar_Dados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Alterar Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JL_Cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Cod.setText("Código*:");

        JTF_Cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JL_Desc_Alterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Desc_Alterar.setText("Descrição*:");

        JTF_Desc_Alterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JL_Situacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Situacao.setText("Situação*:");

        JCB_Situacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "ATIVO", "INATIVO" }));

        javax.swing.GroupLayout JP_Alterar_DadosLayout = new javax.swing.GroupLayout(JP_Alterar_Dados);
        JP_Alterar_Dados.setLayout(JP_Alterar_DadosLayout);
        JP_Alterar_DadosLayout.setHorizontalGroup(
            JP_Alterar_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Alterar_DadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_Cod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_Desc_Alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTF_Desc_Alterar)
                .addGap(12, 12, 12)
                .addComponent(JL_Situacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        JP_Alterar_DadosLayout.setVerticalGroup(
            JP_Alterar_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Alterar_DadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Alterar_DadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Cod)
                    .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Desc_Alterar)
                    .addComponent(JTF_Desc_Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Situacao)
                    .addComponent(JCB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Alterar_Dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP_Categoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JP_TB_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JP_Organizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_TB_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JP_Organizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JP_Alterar_Dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(BT_Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(BT_Cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BT_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(714, 442));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        if(ControleSalvar == false){        
            Testar_Campos_Salvar();
        }
        if(ControleSalvar==true){
            Testar_Campos_Alterar();
        }
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
       if(ControleSalvar == false){        
            Sair_Sem_Salvar();
            ObjCadProd.Inicio_CB_Categoria();
        }
        if(ControleSalvar==true){
            Sair_Sem_Salvar_Alterar();
            ObjCadProd.Inicio_CB_Categoria();
        }             
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_EditarActionPerformed
        try {
             int Sel_Curso = JTB_Categoria.getSelectedRow();
                if (Sel_Curso >= 0) {
                    JTF_Categoria.setText("");
                    ControleSalvar = true;
                    Habilita_Alterar();
                    Desabilita_Cadastrar();
                    Object resultado = JTB_Categoria.getValueAt(JTB_Categoria.getSelectedRow(), 0);
                    ObjControlCategoria.Consulta_Categoria(ObjModCategoria, resultado);
                    Setar_Campos_Alterar();
                    BT_Cancelar.setEnabled(true);
                    BT_Editar.setEnabled(false);
                }
        } catch (HeadlessException | SQLException ex) {

        }
    }//GEN-LAST:event_BT_EditarActionPerformed

    private void BT_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CancelarActionPerformed
        Mostrar_Cancelar_Alteracao();
    }//GEN-LAST:event_BT_CancelarActionPerformed

    private void JRB_InativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_InativoActionPerformed
        Preencher_Tabela_Categoria("select * from categoria_produto where situacao= 'INATIVO' order by categoria");
        Desabilita_Alterar();
        Habilita_Cadastrar();
        Limpar_Campos_Alterar();
        ControleSalvar = false;
        BT_Cancelar.setEnabled(false);
        BT_Editar.setEnabled(false);
    }//GEN-LAST:event_JRB_InativoActionPerformed

    private void JRB_AtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_AtivoActionPerformed
        Preencher_Tabela_Categoria("select * from categoria_produto where situacao= 'ATIVO' order by categoria");
        Desabilita_Alterar();
        Habilita_Cadastrar();
        Limpar_Campos_Alterar();
        ControleSalvar = false;
        BT_Cancelar.setEnabled(false);
        BT_Editar.setEnabled(false);
    }//GEN-LAST:event_JRB_AtivoActionPerformed

    private void JRB_TodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_TodosActionPerformed
         Preencher_Tabela_Categoria("select * from categoria_produto order by categoria");
         Desabilita_Alterar();
         Habilita_Cadastrar();
         Limpar_Campos_Alterar();
         ControleSalvar = false;
         BT_Cancelar.setEnabled(false);
         BT_Editar.setEnabled(false);
    }//GEN-LAST:event_JRB_TodosActionPerformed

    private void JTB_CategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_CategoriaMouseClicked
         try {
             int Sel_Curso = JTB_Categoria.getSelectedRow();
                if (Sel_Curso >= 0) {
                        BT_Editar.setEnabled(true);
                        Object resultado = JTB_Categoria.getValueAt(JTB_Categoria.getSelectedRow(), 0);
                        ObjControlCategoria.Consulta_Categoria(ObjModCategoria, resultado);
                        Setar_Campos_Alterar();
                    if (evt.getClickCount() == 2) {
                        JTF_Categoria.setText("");
                        ControleSalvar = true;
                        Habilita_Alterar();
                        Desabilita_Cadastrar();
                        ObjControlCategoria.Consulta_Categoria(ObjModCategoria, resultado);
                        Setar_Campos_Alterar();
                        BT_Cancelar.setEnabled(true);
                        BT_Editar.setEnabled(false);
                    }
            }
        } catch (HeadlessException | SQLException ex) {

        }
    }//GEN-LAST:event_JTB_CategoriaMouseClicked

    public final void Desabilita_Alterar(){
        JP_Alterar_Dados.setEnabled(false);
        JTF_Cod.setEnabled(false);
        JTF_Desc_Alterar.setEnabled(false);
        JCB_Situacao.setEnabled(false);
        JP_Alterar_Dados.setEnabled(false);
        JL_Cod.setEnabled(false);
        JL_Desc_Alterar.setEnabled(false);
        JL_Situacao.setEnabled(false);
    }
    
    public void Habilita_Alterar(){
        JP_Alterar_Dados.setEnabled(!false);
        JTF_Desc_Alterar.setEnabled(!false);
        JCB_Situacao.setEnabled(!false);
        JP_Alterar_Dados.setEnabled(!false);
        JL_Cod.setEnabled(!false);
        JL_Desc_Alterar.setEnabled(!false);
        JL_Situacao.setEnabled(!false);
    }
    public void Desabilita_Cadastrar(){
        JP_Categoria.setEnabled(false);
        JL_Descricao.setEnabled(false);
        JTF_Categoria.setEditable(false);
    }
    public void  Habilita_Cadastrar(){
        JP_Categoria.setEnabled(!false);
        JL_Descricao.setEnabled(!false);
        JTF_Categoria.setEditable(!false);
    }
          
    public void Preencher_Objetos_Categoria(){
        ObjModCategoria.setCategoria(JTF_Categoria.getText().trim());
    }
    
    public void Preencher_Objetos_Alterar(){
        ObjModCategoria.setCategoria(JTF_Desc_Alterar.getText().trim());
        ObjModCategoria.setSituacao(JCB_Situacao.getSelectedItem().toString());
    }
    
    public void Setar_Campos_Alterar(){
        JTF_Cod.setText(String.valueOf(ObjModCategoria.getId_categoria()));
        JTF_Desc_Alterar.setText(ObjModCategoria.getCategoria());
        JCB_Situacao.setSelectedItem(ObjModCategoria.getSituacao());        
    }
    
    public void Limpar_Campos_Alterar(){
        JTF_Cod.setText("");
        JTF_Desc_Alterar.setText("");
        JCB_Situacao.setSelectedIndex(0);
    }
    public void Sair_Sem_Salvar(){
         if(!JTF_Categoria.getText().equalsIgnoreCase("")){
            Mostrar_Sair_Sem_Salvar();
         }else{
             dispose();
         }
    }
    public void Sair_Sem_Salvar_Alterar(){
        if((!JTF_Cod.getText().equalsIgnoreCase("")||(!JTF_Desc_Alterar.getText().equalsIgnoreCase(""))
                ||(JCB_Situacao.getSelectedIndex()!=0))){
            Mostrar_Sair_Sem_Salvar();
        }else{
            dispose();
        }
    }
    
    public void Testar_Campos_Salvar(){
        if(JTF_Categoria.getText().equalsIgnoreCase("")){
            Mostrar_Preencher_Campos();
            ControleSalvar=false;
        }
        else{            
            Testar_Existente(JTF_Categoria);
                if(ControleExistente==true)
                {
                   Mostrar_Cadastro_Existente();
                   ControleExistente = false;
                }else{
                   Mostrar_Confirma_Salvar();
                }
        }
    }
    public void Testar_Campos_Alterar(){
        if((JTF_Cod.getText().equalsIgnoreCase("")||JTF_Desc_Alterar.getText().equalsIgnoreCase("")
                ||JCB_Situacao.getSelectedIndex()==0)){
            Mostrar_Preencher_Campos();
            ControleSalvar=true;
        }
        else if(JTF_Desc_Alterar.getText().equalsIgnoreCase(ObjModCategoria.getCategoria()))
        {
            Mostrar_Confirma_Alterar();
        }
        else{
            Testar_Existente(JTF_Desc_Alterar);
                if(ControleExistente==true)
                {
                   Mostrar_Cadastro_Existente();
                   ControleExistente = false;
                }
                else{
                    Mostrar_Confirma_Alterar();
                }
            }
    }
    public void Testar_Existente(JTextField jt){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from categoria_produto");        
            ObjConecta.rs.first();            
            do
            {
                String categoria = ObjConecta.rs.getString("categoria");
                if(jt.getText().equalsIgnoreCase(categoria)){
                   ControleExistente=true;
                }
            }
            while(ObjConecta.rs.next());
            } catch (SQLException ex) {
            ControleExistente=false;
            Logger.getLogger(Tela_Cadastro_Categoria_DL1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Alterar_Categoria(){
        Preencher_Objetos_Alterar();
        ObjControlCategoria.Alterar_Categoria(ObjModCategoria, JTF_Cod.getText().trim());
        ObjCadProd.Preencher_CB_Categoria();
        ObjCadProd.Inicio_CB_Categoria();
        Preencher_Tabela_Categoria("select * from categoria_produto order by categoria");
        BT_Editar.setEnabled(false);
        BT_Cancelar.setEnabled(false);
        ControleSalvar=false;
    }
    public void Salvar_Categoria(){
        Preencher_Objetos_Categoria();
        ObjControlCategoria.Inserir_Categoria(ObjModCategoria);
        ObjCadProd.Preencher_CB_Categoria();
        ObjCadProd.Inicio_CB_Categoria();      
    }
    
    public void Conf_Salvar_Categoria(){
        Salvar_Categoria();
        if(ObjControlCategoria.Confirma_Inserir==true){
            Mostrar_Dados_Salvos();
            Habilita_Cadastrar();
            ObjControlCategoria.Confirma_Inserir=false;
            dispose();            
        }else{
            Mostrar_Dados_Nao_Salvos();
            ObjControlCategoria.Confirma_Inserir=false;
        }
        
    }
    public void Conf_Alterar_Categoria(){
        Alterar_Categoria();
        if(ObjControlCategoria.Confirma_Alterar==true){
            Mostrar_Dados_Alterados();
            Limpar_Campos_Alterar();
            Habilita_Cadastrar();
            Desabilita_Alterar();
            ObjControlCategoria.Confirma_Alterar=false;
        }else{
            Mostrar_Dados_Nao_Alterados();
            ObjControlCategoria.Confirma_Alterar=false;
        }
    }
    public void Conf_Cancelar_Alterar(){
        Limpar_Campos_Alterar();
        Desabilita_Alterar();
        ControleSalvar = false;
        BT_Cancelar.setEnabled(false);Habilita_Cadastrar();
        JTF_Categoria.requestFocus();
    }
    
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Categ1(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Alterados(){
        ObjDadosAlterados = new Inf_Dados_Alterados_Categ1(this, true);
        ObjDadosAlterados.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Categ1(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Alterados(){
        ObjDadosNaoAlterados = new Inf_Dados_Nao_Alterados_Categ1(this, true);
        ObjDadosNaoAlterados.setVisible(true);
    }
    public void Mostrar_Confirma_Salvar(){
        ObjConfSalvar = new Conf_Salvar_Categoria1(this, true);
        ObjConfSalvar.setVisible(true);
    }
    public void Mostrar_Confirma_Alterar(){
        ObjConfAlterar = new Conf_Alterar_Categoria1(this, true);
        ObjConfAlterar.setVisible(true);
    }
    public void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Categ1(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Cadastro_Existente(){
        ObjCadastroExiste = new Inf_Cadastro_Existente_Categ1(this, true);
        ObjCadastroExiste.setVisible(true);
    }
    public void Mostrar_Cancelar_Alteracao(){
        ObjCancelarAlterar = new Conf_Cancelar_Categ1(this, true);
        ObjCancelarAlterar.setVisible(true);
    }
    
    public void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Categ1(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
     
    public final void Preencher_Tabela_Categoria(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Categoria", "Situação"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();
           
            do {
                dados.add(new Object[]{ObjConecta.rs.getInt("id_categoria"),ObjConecta.rs.getString("categoria"),
                ObjConecta.rs.getString("situacao")});
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Categoria.setModel(tabela);
        JTB_Categoria.getColumnModel().getColumn(0).setPreferredWidth(100);//Tamanho da coluna
        JTB_Categoria.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Categoria.getColumnModel().getColumn(1).setPreferredWidth(320);
        JTB_Categoria.getColumnModel().getColumn(1).setResizable(false);
        JTB_Categoria.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTB_Categoria.getColumnModel().getColumn(2).setResizable(false);
        JTB_Categoria.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Categoria.setAutoResizeMode(JTB_Categoria.AUTO_RESIZE_OFF);//Tabela Redimensionavel(Não)
        JTB_Categoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
     
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Categoria_DL1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Categoria_DL1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Categoria_DL1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Categoria_DL1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Cadastro_Categoria_DL1 dialog = new Tela_Cadastro_Categoria_DL1(new Tela_Cadastro_Prod_Edit(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_Situacao;
    private javax.swing.JButton BT_Cancelar;
    private javax.swing.JButton BT_Editar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Situacao;
    private javax.swing.JLabel JL_Cod;
    private javax.swing.JLabel JL_Desc_Alterar;
    private javax.swing.JLabel JL_Descricao;
    private javax.swing.JLabel JL_Situacao;
    private javax.swing.JPanel JP_Alterar_Dados;
    private javax.swing.JPanel JP_Categoria;
    private javax.swing.JPanel JP_Organizar;
    private javax.swing.JPanel JP_TB_Categoria;
    private javax.swing.JRadioButton JRB_Ativo;
    private javax.swing.JRadioButton JRB_Inativo;
    private javax.swing.JRadioButton JRB_Todos;
    private javax.swing.JTable JTB_Categoria;
    private javax.swing.JTextField JTF_Categoria;
    private javax.swing.JTextField JTF_Cod;
    private javax.swing.JTextField JTF_Desc_Alterar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}