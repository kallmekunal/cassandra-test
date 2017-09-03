package com.kunal.databases.cassandratest;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;

public class CassandraUtility {

	Session mySession;
	Cluster myCluster;
	
	public void connect(String nodeName,Integer portNumber){
		Builder b = Cluster.builder().addContactPoint(nodeName);
		if(portNumber!=null )
		{
			b.withPort(portNumber);
		}
		
		myCluster = b.build();
		mySession = myCluster.connect();
	}
	
	
	public Session getSession(){
		return mySession;
	}
	
	public void closeSession(){
		mySession.close();
		myCluster.close();
	}
	
	
	
	/**
	 * @param keyspaceName
	 * @param replicationStrategy
	 * @param replicationFactor
	 */
	public void createKeyspace(
			  String keyspaceName, String replicationStrategy, int replicationFactor) {
			  StringBuilder sb = 
			    new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
			      .append(keyspaceName).append(" WITH replication = {")
			      .append("'class':'").append(replicationStrategy)
			      .append("','replication_factor':").append(replicationFactor)
			      .append("};");
			         
			    String query = sb.toString();
			    mySession.execute(query);
			}
	
	public boolean ifKeySpaceExists(String keySpaceName){
		if(myCluster.getMetadata().getKeyspace(keySpaceName) == null){
			return false;
			
		}else{
			return true;
		}
	}
}
