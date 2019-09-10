/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.ColorEnum;
import entities.ClassMember;
import java.util.Objects;

/**
 *
 * @author Martin
 */
public class ClassMemberDTO {
    private long id;
    private String name;
    private String studentId;
    private ColorEnum color;
    private String link;

    public ClassMemberDTO(ClassMember member) {
        this.id = member.getId();
        this.name = member.getName();
        this.studentId = member.getStudentId();
        this.color = member.getColor();
        this.link = member.getLink();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public ColorEnum getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.studentId);
        hash = 31 * hash + Objects.hashCode(this.color);
        hash = 31 * hash + Objects.hashCode(this.link);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClassMemberDTO other = (ClassMemberDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.link, other.link)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        return true;
    }
 
}
