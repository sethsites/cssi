package com.sethsites.cssi.dto;

import com.sethsites.cssi.entity.CssiScore;
import com.sethsites.cssi.entity.CssiScoring;
import com.sethsites.cssi.entity.Variable;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 5:22 PM
 */
public class CityIndicatorScatterPlotDTO {
    private String name;
     private int[] x;
     private int[] y;
     private String mode = "markers";
     private String textposition = "bottom center";
     private String[] text;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int[] getX() {
         return x;
     }

     public void setX(int[] x) {
         this.x = x;
     }

     public int[] getY() {
         return y;
     }

     public void setY(int[] y) {
         this.y = y;
     }

     public String getMode() {
         return mode;
     }

     public String[] getText() {
         return text;
     }

     public void setText(String[] text) {
         this.text = text;
     }

     public String getTextposition() {
         return textposition;
     }

     public static CityIndicatorScatterPlotDTO toDTO(CssiScoring scoring) {
         CityIndicatorScatterPlotDTO dto = new CityIndicatorScatterPlotDTO();
         dto.setName(scoring.getCity().getName());
         int[] x = new int[31];
         int[] y = new int[31];
         String[] text = new String[31];

         for (int i = 0; i < 30; i++) {
             x[i] = 0;
             y[i] = 0;
         }

         for (CssiScore score : scoring.getCssiScores()) {
             if (score.getVariable().getType() == Variable.Type.CAPABILITY || score.getVariable().getType() == Variable.Type.BOTH) {
                 x[score.getVariable().getIndicator().getId().intValue() - 1] += score.getScore();
             }
             if (score.getVariable().getType() == Variable.Type.WILL || score.getVariable().getType() == Variable.Type.BOTH) {
                 y[score.getVariable().getIndicator().getId().intValue() - 1] += score.getScore();
             }
             if(text[score.getVariable().getIndicator().getId().intValue() - 1] == null) {
                 text[score.getVariable().getIndicator().getId().intValue() - 1] = score.getVariable().getIndicator().getSubsystem().getName() + " - " + score.getVariable().getIndicator().getName();
             }
         }
         
         dto.setX(x);
         dto.setY(y);
         dto.setText(text);
         return dto;
     }
}
