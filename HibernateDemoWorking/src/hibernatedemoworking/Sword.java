
package hibernatedemoworking;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Class: Sword
 * Purpose: Map Descriptive aspects of a Sword to match Database. 
 * @author jamesK
 */
@Entity
@Table(name= "swords")
public class Sword implements Serializable {

    // member variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "swordID")
    public int swordID;
    
    @Column(name = "swordName")
    public String swordName;
    
    @Column(name = "swordCulture")
    public String swordCulture;
    
    @Column(name = "bladeShape")
    public String bladeShape;

    public Sword() {
    }
    
    // constructor
    public Sword(String swordName, String swordCulture, String bladeShape){
        this.swordName = swordName;
        this.swordCulture = swordCulture;
        this.bladeShape = bladeShape;
    }
        
    // getters and setters
    
    public int getSwordID() {
        return swordID;
    }

    public void setSwordID(int swordID) {
        this.swordID = swordID;
    }

    public String getSwordName() {
        return swordName;
    }

    public void setSwordName(String swordName) {
        this.swordName = swordName;
    }

    public String getSwordCulture() {
        return swordCulture;
    }

    public void setSwordCulture(String swordCulture) {
        this.swordCulture = swordCulture;
    }

    public String getBladeShape() {
        return bladeShape;
    }

    public void setBladeShape(String bladeShape) {
        this.bladeShape = bladeShape;
    }

    @Override
    public String toString() {
        return "Sword{" + "swordID=" + swordID + ", swordName=" + swordName + ", swordCulture=" + swordCulture + ", bladeShape=" + bladeShape + '}';
    }    
}
