package com.sethsites.cssi.dto;

import com.sethsites.cssi.entity.CssiScoring;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 4:45 PM
 */
public class CitiesOverviewScatterPlotDTO {
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

    public String getTextposition() {
        return textposition;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public static CitiesOverviewScatterPlotDTO toDTO(CssiScoring scoring) {
        CitiesOverviewScatterPlotDTO dto = new CitiesOverviewScatterPlotDTO();
        dto.setName(scoring.getCity().getName());
        int[] x = new int[1];
        x[0] = scoring.getCapabilityScore();
        dto.setX(x);

        int[] y = new int[1];
        y[0] = scoring.getWillScore();
        dto.setY(y);

        String[] text = new String[4];
        text[0] = dto.getName();
        dto.setText(text);
        return dto;
    }
}
