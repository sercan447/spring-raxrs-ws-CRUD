package com.mimaraslan.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.mimaraslan.bean.Musteri;
import com.mimaraslan.dao.MusteriDAO;

public class MusteriDAOImpl implements MusteriDAO{

	static Connection con = null;
	
	@Override
	public Connection veritabaninaBaglantiKur() {
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
	
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme_lv_1","root","199144");
		
		if(!con.isClosed())
		{
			System.out.println("Veritabani Ba�ar�yla bagland�");
		}else {
			System.out.println("Baglanti Sorunu VT");
		}
			
		}catch(Exception e)
		{
			System.out.println("HATALADNI : "+e.getMessage());
		}finally {
			
			System.out.println("AHA DAYI YA SOR");
		}
		return con;
	}
	
	/*public static void main(String[] args) {
		
		MusteriDAOImpl it = new MusteriDAOImpl();
		it.veritabaninaBaglantiKur();
	}
*/
	@Override
	public List<Musteri> veriOku() {
			
		veritabaninaBaglantiKur();		
		
		List<Musteri> musteriler = new ArrayList<Musteri>();
		Musteri musteri = null;
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM musteri");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				musteri = new Musteri(resultSet.getInt(1),
									 resultSet.getInt(2),
									 resultSet.getString(3),
									 resultSet.getString(4));
				musteriler.add(musteri);
				
			}//WHILE
		}catch(Exception e)
		{
			System.out.println("VERINNI HEPSININ OKUMADA HATA  "+e.getMessage());
		}finally {
			
			
		}
		return musteriler;
	}

	@Override
	public Musteri veriOku(int musteriId) {
			
		veritabaninaBaglantiKur();
		
		Musteri musteri = null;
		
		try {
			String sorgu = "SELECT * FROM deneme_lv_1.musteri WHERE musteriId = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sorgu);
							  preparedStatement.setInt(1, musteriId);

			ResultSet resultset = preparedStatement.executeQuery();
			
			while(resultset.next())
			{
				musteri = new Musteri(resultset.getInt(1),
									  resultset.getInt(2),
									  resultset.getString(3),
									  resultset.getString(4));
			}//WH�LE
		}catch(Exception e) {
			System.out.println("HATA : "+e.getMessage());
		}finally {
			System.out.println(musteri);
		}
		
		return musteri;
	}

	@Override
	public boolean veriEkle(Musteri musteri) {
		veritabaninaBaglantiKur();
		
		boolean eklemeDurumu = false;
		String sonuc = "";
		try {
			
			String sorgu = "INSERT INTO Musteri(musteriNo,musteriAdi,musteriSoyadi) VALUES(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sorgu);
							  preparedStatement.setInt(1,musteri.getMusteriNo());
							  preparedStatement.setString(2, musteri.getMusteriAdi());
							  preparedStatement.setString(3, musteri.getMusteriSoyadi());
							  
							  eklemeDurumu = preparedStatement.execute();
							  
							  if(eklemeDurumu == false)
								  sonuc = "Ekleme Ba�ar�l�";
							  else
								  sonuc = "Ekleme Ba�ar�s�z";
		}catch(Exception e) {
			System.out.println("EKLEME HATASI : "+e.getMessage());	
		}finally {
			System.out.println(sonuc);
		}
		
		return eklemeDurumu;
	}

	@Override
	public boolean veriDuzenle(Musteri musteri, int musteriId) {
		
		veritabaninaBaglantiKur();
		
		boolean duzenlemeDurumu = false;
		String mesajSonuc = "";
		
		try {
			String sorgu = "UPDATE musteri SET musteriNo = ?,musteriAdi = ?, musteriSoyadi = ? WHERE musteriId = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sorgu);
							 preparedStatement.setInt(1, musteri.getMusteriNo());
							 preparedStatement.setString(2, musteri.getMusteriAdi());
							 preparedStatement.setString(3, musteri.getMusteriSoyadi());
							 preparedStatement.setInt(4, musteri.getMusteriId());
							 
							 int sorguSonucu = preparedStatement.executeUpdate();
							 
							 if(sorguSonucu == 1)
							 {
								 mesajSonuc = "D�zenleme ba�ar�l�";
								 duzenlemeDurumu = true;	
							 }else {
								 mesajSonuc = "D�zenleme ba�ar�s�z";
								 duzenlemeDurumu = false;
							 }
			
		}catch(Exception e)
		{
			System.out.println("DUZENLEME : "+e.getMessage());
		}finally {
			System.out.println(mesajSonuc);
		}
		
		return duzenlemeDurumu;
	}

	@Override
	public boolean veriSilme(int musteriId) {
			
		veritabaninaBaglantiKur();
		
		boolean silmeDurumu = false;
		String sonuc = "";
		
		try {
			String sorgu = "DELETE FROM Musteri WHERE musteriId = ?";
			
			PreparedStatement preparedStatement = con.prepareStatement(sorgu);
							  preparedStatement.setInt(1, musteriId);
							  
				silmeDurumu = preparedStatement.execute();
				
				if(silmeDurumu == false)
					sonuc = "Silme Ba�ar�l�";
				else
					sonuc = "Silme ba�ar�s�z";
				
		}catch(Exception e) {
			System.out.println("HATA : "+e.getMessage());
		}finally {
			
			System.out.println(sonuc);
		}
		
		return silmeDurumu;
	}

}
