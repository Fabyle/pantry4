package fr.fabien.taskmanagement.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
			List<Tache> list = null;
			
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			list = session.selectList("Tache.selectAll");
			for (Tache tache : list) {
				System.out.println(tache);
			}
			
		} catch (IOException ex) {
			// TODO bloc catch squelette auto-généré
			ex.printStackTrace();
		}
       
    }
}
