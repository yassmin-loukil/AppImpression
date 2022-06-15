package tn.iit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String username;
    
    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;
    

    @Column(name = "etat")
    private String etat;
    
    
    public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	public User( String firstName,String lastName, String userName, String password, String role,String etat) {
  	  super();
  	  this.firstName = firstName ;
  	this.lastName = lastName ;
  	this.username = userName ;
  	  this.password= password;
  	this.role= role;
  	this.etat=etat;
  	 }

	public User( int id,String firstName,String lastName, String userName, String password, String role,String etat) {
	  	  super();
	  	  this.id=id;
	  	  this.firstName = firstName ;
	  	this.lastName = lastName ;
	  	this.username = userName ;
	  	  this.password= password;
	  	this.role= role;
	  	this.etat=etat;
	  	 }


    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role= role;
    }
}