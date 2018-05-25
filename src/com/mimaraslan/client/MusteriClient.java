package com.mimaraslan.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


public class MusteriClient {

	
	public static void main(String[] args)
	{
		String URL ="http://localhost:8096/_18_RESTful_CRUD/rest/musteri/4";
		
	
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(URL);
			
			Response response = target.request().get();
			
			System.out.println(response.readEntity(String.class));
	}
}

