package be.ephec.monopoly.reseau;

import be.ephec.modele.*;
import be.ephec.network.*;
import be.ephec.GUI.GuiClient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client extends Socket {
	private String nom;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;


	public String getNom() {
		return nom;
	}
	
	public Client() throws UnknownHostException, IOException {
		super("127.0.0.1", 62900);
		this.nom = JOptionPane.showInputDialog("Merci de saisir ton nom");	
	}
	
	
	
	public Client(Socket socket) throws IOException{
		this.socket = socket;
		this.nom = nom;
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		oos.writeObject("Client "+nom);
	}
	
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object lire() throws ClassNotFoundException, IOException{
		return ois.readObject();
	}

	public static void main(String[] args) {
		try {
			Client mc = new Client();
			ObjectInputStream ois = new ObjectInputStream(mc.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(mc.getOutputStream());
			oos.writeObject("bonjour du client");
			while(!mc.isClosed()){
				System.out.println(ois.readObject());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public void run() {
		try {
			GuiClient frame = new GuiClient(nom);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

