package com.sethsites.cssi.dto;

import com.sethsites.cssi.entity.CssiScoring;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 3:09 PM
 *
 *             x: [105, 29, 114, 72],
               y: [25, 125, 85, 35],
               mode: 'markers+text',
               type: 'scatter',
               name: 'Paris',
               text: ['Paris - Psyche', 'Paris - Physiology', 'Paris - Anatomy', 'Paris - Relational'],
                 legendgroup: 'Paris',
               textposition: 'bottom center',
               textfont: {
                 family:  'Times New Roman'
               },
               marker: { size: 12 }
 */
public class CityScatterPlotDTO {
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

    public static CityScatterPlotDTO toDTO(CssiScoring scoring) {
        CityScatterPlotDTO dto = new CityScatterPlotDTO();
        dto.setName(scoring.getCity().getName());
        int[] x = new int[4];
        x[0] = scoring.getPsycheCapabilityScore();
        x[1] = scoring.getPhysiologyCapabilityScore();
        x[2] = scoring.getAnatomyCapabilityScore();
        x[3] = scoring.getRelationalCapabilityScore();
        dto.setX(x);

        int[] y = new int[4];
        y[0] = scoring.getPsycheWillScore();
        y[1] = scoring.getPhysiologyWillScore();
        y[2] = scoring.getAnatomyWillScore();
        y[3] = scoring.getRelationalWillScore();
        dto.setY(y);

        String[] text = new String[4];
        text[0] = "Psyche";
        text[1] = "Physiology";
        text[2] = "Anatomy";
        text[3] = "Relational";
        dto.setText(text);
        return dto;
    }
}
