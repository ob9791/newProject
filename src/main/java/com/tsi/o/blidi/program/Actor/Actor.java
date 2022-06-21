package com.tsi.o.blidi.program.Actor;

import javax.persistence.*;

/*
This Java class is used to model an actor. The specific information used to model the actor are the first and last names,
as well as the inherent id property.
For the purposes of this project, the first name and last name are suited to meet the project goals
java does not know what an actor is, I am giving it definitions that model an actor

 */

@Entity
@Table(name="actor")
public class Actor {

    /*

     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    //attributes
    private String first_name;
    private String last_name;

    //constructor
    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Actor(int actor_id, String first_name, String last_name){
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    //Empty contrsuctor
    //empty constructor used to hold all data from table
    public Actor(){}

    // getters nd setters

    public int getActor_id(){
        return actor_id;
    }

    public void setActor_id(int actor_id){
        this.actor_id = actor_id;
    }

    public String getFirst_name(){
        return first_name = first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

}
