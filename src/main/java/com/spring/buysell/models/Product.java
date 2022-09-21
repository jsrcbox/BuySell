package com.spring.buysell.models;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long ID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description", columnDefinition = "text")
	private String description;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "author")
	private String author;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, 
			mappedBy = "product")
	//@JoinColumn
	private List<Image> images = new ArrayList<>();
	private Long previewImageId;
	private LocalDateTime dateOfCreated;
	
	@PrePersist
	private void init() {
		dateOfCreated = LocalDateTime.now();
	}
	
	public void addImageToProduct(Image image) {
		image.setProduct(this);
		images.add(image);
	}

}
