/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auladb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author 0077530
 */
public class AulaDb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FuncionarioDao dao = new FuncionarioDao();
//            List<Funcionario> lista = dao.getTodos();
//            Funcionario fjoaquim = null;
//            for (Funcionario elem : lista) {
//                System.out.println("ID "+elem.getId() + "\nNome: " + elem.getNome());
//                if (elem.getId()==3){
//                    fjoaquim = elem;
//                }
//            }
//            
//            fjoaquim.setNome("Joaquim da Silva");
//            dao.atualiziar(fjoaquim);
              Funcionario f55 = dao.getById(1);
              if (f55 == null){
                  System.out.println("Funcionario não encontrado");
              }
              System.out.println(f55.getNome());
              
              
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
