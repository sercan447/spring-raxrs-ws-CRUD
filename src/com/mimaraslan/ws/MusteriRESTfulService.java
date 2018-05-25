package com.mimaraslan.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mimaraslan.bean.Musteri;
import com.mimaraslan.dao.impl.MusteriDAOImpl;

@Path("/musteri")
public class MusteriRESTfulService {
	
	
	@GET
	@Path("/herkes")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON + ";charset=utf-8"})
	//@Consumes()
	public List<Musteri> musterileriGetir(){
		
		MusteriDAOImpl impl = new MusteriDAOImpl();
		return impl.veriOku();
	}
	
	@GET
	@Path("/{musteriId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON + ";charset=utf-8"})
	public Musteri musteriGetirById(@PathParam("musteriId")int musteriId)
	{
		MusteriDAOImpl getir = new MusteriDAOImpl();
				
		return getir.veriOku(musteriId);
	}
	
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON+"; charset=utf-8"})
	
	public Response musteriEkle(Musteri musteri)
	{
		MusteriDAOImpl ekle = new MusteriDAOImpl();
				boolean ekleDurumu = ekle.veriEkle(musteri);	
		
				if(ekleDurumu == false)
					return Response.status(201).build();
				else
					return Response.status(204).build();
	}
	
	
	@PUT
	@Path("/{musteriId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON+"; charset=utf-8"})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON+"; charset=utf-8"})
	public Musteri musteriDuzenle(@PathParam("musteriId")int musteriId,Musteri musteri)
	{
		MusteriDAOImpl duzenle = new MusteriDAOImpl();
		boolean duzenlemeDurumu = duzenle.veriDuzenle(musteri, musteriId);
		
		if(duzenlemeDurumu == true)
			return musteri;
		else
		return null;
	}
	
	@DELETE
	@Path("/{musteriId}")
	public Response musteriSil(@PathParam("musteriId")int musteriId)
	{
		MusteriDAOImpl sil = new MusteriDAOImpl();
		boolean silmeDurumu = sil.veriSilme(musteriId);
		
		if(silmeDurumu == false)
			return Response.status(200).build();
		else
			return Response.status(204).build();
	
	}
	
	/*@GET
	@Path("/dene")
	@Produces(MediaType.TEXT_PLAIN)
	public String deneme() {
		
		return "Denedim oLDU";
	}
	*/
	

}
