package theme;

import java.awt.Color;

public class Theme {
    private String name;
    private Color backgroundColor;
    private Color foregroundColor;
    private Color accentColor;
    private Color barColor;
    private Color highlightColor;
    private Color textColor;

    public Theme(String name, Color backgroundColor, Color foregroundColor, Color accentColor,
                 Color barColor, Color highlightColor, Color textColor) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.accentColor = accentColor;
        this.barColor = barColor;
        this.highlightColor = highlightColor;
        this.textColor = textColor;
    }

    public String getName() { return name; }
    public Color getBackgroundColor() { return backgroundColor; }
    public Color getForegroundColor() { return foregroundColor; }
    public Color getAccentColor() { return accentColor; }
    public Color getBarColor() { return barColor; }
    public Color getHighlightColor() { return highlightColor; }
    public Color getTextColor() { return textColor; }
}
