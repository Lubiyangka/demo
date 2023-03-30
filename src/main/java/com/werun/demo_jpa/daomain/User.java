package com.werun.demo_jpa.daomain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
/*
 *构造相应的函数
 *例如get,set,toString函数
 */
@Entity
//表明该实体类被JPA管理
@Table(name="six")
//注释链接数据库实现实体类和数据库的映射
/*
 *@Entity(name = "six")
 *可以替换上两行
 */
@IdClass(User.class)
public class User implements Serializable {
    //生成策略，这里配置为自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //对应表中id这一列
    @Column(name = "id")
    //此属性为主键
    @Id
    private Integer id;
    //实体类名与数据库表字段名相同的自动映射
    private String type;
    private String name;
}
