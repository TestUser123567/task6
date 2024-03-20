package org.example;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D.Double;


public class ShapeFactory {
   public Shape shape;
   public BasicStroke stroke = new BasicStroke(3.0F);
   public Paint paint;
   public int width = 25;
   public int height = 25;
   private Colors colors;
   private Form form;

   /**
    *
    * @param colors - колір фігури
    * @param form - тип фігури
    */
   public ShapeFactory(Colors colors, Form form) {
      switch(form) {
         case Pentagon:
            this.shape = createStar(3, new Point(0, 0), (double)this.width / 2.0D, (double)this.width / 2.0D);
            break;
         case Star:
            this.shape = createStar(5, new Point(0, 0), (double)this.width / 2.0D, (double)this.width / 4.0D);
            break;
         case Square:
            this.shape = new Double((double)(-this.width) / 2.0D, (double)(-this.height) / 2.0D, (double)this.width, (double)this.height);
            break;
         case Triangle:
            GeneralPath path = new GeneralPath();
            double tmp_height = Math.sqrt(2.0D) / 2.0D * (double)this.height;
            path.moveTo((double)(-this.width / 2), -tmp_height);
            path.lineTo(0.0D, -tmp_height);
            path.lineTo((double)(this.width / 2), tmp_height);
            path.closePath();
            this.shape = path;
            break;
         case Circle:
            this.shape = new java.awt.geom.Arc2D.Double((double)(-this.width) / 2.0D, (double)(-this.height) / 2.0D, (double)this.width, (double)this.height, 30.0D, 300.0D, 2);
         default:
            throw new Error("type is nusupported");
      }

      switch(colors) {
         case Black:
            this.stroke = new BasicStroke(3.0F);
            break;
         case Bold:
            this.stroke = new BasicStroke(7.0F);
            break;
         case White_grey_gradient:
            this.paint = new GradientPaint((float)(-this.width), (float)(-this.height), Color.white, (float)this.width, (float)this.height, Color.gray, true);
            break;
         case Red:
            this.paint = Color.red;
            break;
         default:
            throw new Error("type is nusupported");
      }

   }

   /**
    *
    * @param arms - кількість вершин
    * @param center - центер зірки
    * @param rOuter - зовнішній радіус
    * @param rInner - внутрішній радіус
    * @return Object - повертає обєкт типу Shapr зірку.
    */
   private static Shape createStar(int arms, Point center, double rOuter, double rInner) {
      double angle = 3.141592653589793D / (double)arms;
      GeneralPath path = new GeneralPath();

      for(int i = 0; i < 2 * arms; ++i) {
         double r = (i & 1) == 0 ? rOuter : rInner;
         java.awt.geom.Point2D.Double p = new java.awt.geom.Point2D.Double((double)center.x + Math.cos((double)i * angle) * r, (double)center.y + Math.sin((double)i * angle) * r);
         if (i == 0) {
            path.moveTo(p.getX(), p.getY());
         } else {
            path.lineTo(p.getX(), p.getY());
         }
      }

      path.closePath();
      return path;
   }
}
