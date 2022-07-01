/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bioskop;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JToggleButton;

/**
 *
 * @author fadhl
 */
public class ColorToggleButton extends JToggleButton {
    
    public void paintComponent(Graphics g){
        Color bg,text;
        if(isSelected()){
            bg = Color.decode("#6666ff");
            text = Color.decode("#000000");
        }
        else{
            bg = Color.decode("#999999");
            text = Color.decode("#999999");
        }
        
        setBackground(bg);
        setForeground(text);
        super.paintComponent(g);
    }
}
