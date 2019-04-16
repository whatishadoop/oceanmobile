package com.sinovatio.modules.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
* @ClassName: Permission
* @Description: 权限对象
* @Author JinLu
* @Date 2019/4/3 17:03
* @Version 1.0
*/
@Entity
@Getter
@Setter
@Table(name = "permission")
public class Permission implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	/**
	 * 上级类目
	 */
	@NotNull
	@Column(name = "pid",nullable = false)
	private Long pid;

	@NotBlank
	private String alias;

	@JsonIgnore
	@ManyToMany(mappedBy = "permissions")
	private Set<Role> roles;

	@CreationTimestamp
	@Column(name = "create_time")
	private Timestamp createTime;

	@Override
	public String toString() {
		return "Permission{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pid=" + pid +
				", alias='" + alias + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
