/**
 * 
 */
package com.openclassrooms.PayMyBuddy.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Nicolas Garland
 *
 */
@Entity
@Data
@Table(name = "friend")
public class Friend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int friendId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private PMBUser user;
	
	@ManyToOne
	@JoinColumn(name = "buddy_id")
	private PMBUser buddy;
	
	@OneToMany(cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY, 
			   mappedBy = "friendship")
	private List<Transaction> transactionList = new ArrayList<>();
	
}
