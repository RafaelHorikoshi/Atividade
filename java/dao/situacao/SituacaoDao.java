package dao.situacao;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Situacao;

public class SituacaoDao implements ISituacaoDao {

    private static final String SELECT_ALL = "SELECT * FROM situacao where descricao ilike ?;";
    private static final String INSERT = "INSERT INTO situacao(descricao) values(?);";
    private static final String DELETE = "DELETE FROM situacao where id=?";
    private static final String BUSCAR = "SELECT * FROM situacao WHERE id=?;";
    private static final String UPDATE = "UPDATE situacao set descricao=? WHERE id=?";

    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Situacao> listar(Situacao situacao) {

        ArrayList<Situacao> listaSituacao = new ArrayList<Situacao>();

        try {

            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
                       
            pstmt.setString(1, "%" + situacao.getDescricao() + "%");
            
            ResultSet rs = pstmt.executeQuery();
            
            
            while (rs.next()) {
                Situacao novoSituacao = new Situacao();
                novoSituacao.setId(rs.getInt("id"));
                novoSituacao.setDescricao(rs.getString("descricao"));

                listaSituacao.add(novoSituacao);
            }
            return listaSituacao;

        } catch (Exception ex) {
            
            return listaSituacao;

        } finally {
                       
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SituacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void buscar(Situacao situacao) {

        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, situacao.getId());
            
            ResultSet rs = pstmt.executeQuery();

            rs.next();

            situacao.setDescricao(rs.getString("descricao"));
         

        } catch (Exception e) {

            //
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SituacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public boolean alterar(Situacao situacao) {
       
         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, situacao.getDescricao());
            pstmt.setInt(2, situacao.getId());

            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

             try {
                 conexao.close();
             } catch (SQLException ex) {
                 Logger.getLogger(SituacaoDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }

    @Override
    public boolean excluir(Situacao situacao) {
       
         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, situacao.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

             try {
                 conexao.close();
             } catch (SQLException ex) {
                 Logger.getLogger(SituacaoDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        
    }

    @Override
    public boolean cadastrar(Situacao situacao) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, situacao.getDescricao());

            pstmt.execute();
            
            return true;

        } catch (Exception ex) {

            return false;
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SituacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}
