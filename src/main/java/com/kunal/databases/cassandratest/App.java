package com.kunal.databases.cassandratest;

import java.util.UUID;

import com.datastax.driver.core.ResultSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String kySpaceName = "kunal_library";
    	CassandraUtility utility = new CassandraUtility();
    	//Setting up the cluster and connection.Prerequisite
    	utility.connect("localhost", 9042);
    	
    	if(!utility.ifKeySpaceExists(kySpaceName))
    	utility.createKeyspace(kySpaceName, "SimpleStrategy", 1);
    	else
    		System.out.println("Keyspace already exists.");
    	//Use newly created keyspace.
    	  utility.getSession().execute("USE kunal_library");
    	//Create table.
    	StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
    		      .append("booksByTitle").append("(")
    		      .append("id uuid, ")
    		      .append("title text,")
    		      .append("PRIMARY KEY (title, id));");
    		 
    		    String query = sb.toString();
    		    utility.getSession().execute(query);
    	//Populate into table.
    		    StringBuilder insertQuery = new StringBuilder("INSERT INTO ").append("booksbytitle")
    		    	      .append("(id, title) ")
    		    	      .append("VALUES (").append(UUID.randomUUID()).append(", '")
    		    	      .append("testing title").append("'").append(");");

    		    String queryInsert = insertQuery.toString();
    		    utility.getSession().execute(queryInsert);
    		    
    		    //Reading the data out of the session.
    		    StringBuilder builder =  new StringBuilder("Select * from  booksbytitle;");
    		    String selectQuery  = builder.toString();
    		    ResultSet resultSet = utility.getSession().execute(selectQuery);
    		    resultSet.forEach(r->System.out.println(r.getUUID("id") + " name "+ r.getString("title")));
    		    
    	utility.closeSession();
    }
}
