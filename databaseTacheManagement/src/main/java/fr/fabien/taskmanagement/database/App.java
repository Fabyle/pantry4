package fr.fabien.taskmanagement.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import fr.fabien.taskmanagement.database.business.EtatTache;
import fr.fabien.taskmanagement.database.business.Tache;
import fr.fabien.taskmanagement.database.services.ServiceJointure;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //String resource = "org/mybatis/example/mybatis-config.xml";
        
        String resource = "mybatis-config.xml";
        
       
		try {
			List<Tache> listTache = null;
			List<EtatTache> listEtatTache = null;
			
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			listTache = session.selectList("Tache.selectAll");
			
			
			listEtatTache = session.selectList("EtatTache.selectAll");
			for (EtatTache etatTache : listEtatTache) {
				System.out.println(etatTache);
			}
			
			ServiceJointure servicejointure = ServiceJointure.getInstance();
			servicejointure.joindreTacheAvecEtatTache(listTache, listEtatTache);
			
			for (Tache tache : listTache) {
				System.out.println(tache);
			}
			
			Tache nouvelle = new Tache();
			nouvelle.setLabel("nouvelle tache");
			nouvelle.setDateCreation(new Date());
			nouvelle.set_BasicEtat("A");
			
			session.insert("Tache.insert",nouvelle);
			
			try{
				// do something with the session
				 
				session.commit();
				}catch(Exception e){
				session.rollback();
				}finally{
				session.close();
				}
			
			
		} catch (IOException ex) {
			// TODO bloc catch squelette auto-généré
			ex.printStackTrace();
		}
       
    }
}
