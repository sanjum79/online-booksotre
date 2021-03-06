package pk.snaseer.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_book")
@Data
//@JsonSerialize(using = BookCustomSerializer.class)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sku;

	private String name;

	private String description;

	private boolean active;

	@JsonIgnore
	private String isbn;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "units_in_stock")
	private int unitsInStock;

	@Column(name = "date_created")
	private Date createdOn;

	@Column(name = "last_updated")
	private Date updatedOn;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private BookCategory category;

}
