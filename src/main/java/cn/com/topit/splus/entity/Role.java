package cn.com.topit.splus.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "role")
@JsonInclude(value=Include.NON_NULL)
@JsonPropertyOrder(alphabetic=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true, includeFieldNames=true) 
public class Role implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String info;
    
}
