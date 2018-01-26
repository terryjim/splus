package cn.com.topit.splus.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 *  用户entity.
 * 不输出空字段
 * @author terry
 */
@Entity
@JsonInclude(value=Include.NON_NULL)
@JsonPropertyOrder(alphabetic=true)
@JsonIgnoreProperties({"password","salt"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true, includeFieldNames=true) 
public class Users implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * @see cn.net.bluechips.ucenter.config.db.DBUserCfg#loginName
     * 
     * 
     */
   
    @Column(length=50,nullable=false)    
    private String name;
    @Column(length=50,nullable=false)
    private String code;     
    private Boolean enable;
    private Integer status;
    @Column(length=200)
    private String password;
   


    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Roles> roles;

   
}
