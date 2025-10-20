package theme;

import java.awt.Color;

public class ThemeManager {
    private static ThemeManager instance;

    private Theme lightTheme;
    private Theme darkTheme;
    private Theme currentTheme;

    private ThemeManager() {
        lightTheme = new Theme("Light", new Color(245,245,245), new Color(230,230,230),
                new Color(100,149,237), new Color(70,130,180), new Color(255,69,0), Color.BLACK);
        darkTheme = new Theme("Dark", new Color(30,30,30), new Color(45,45,45),
                new Color(0,191,255), new Color(100,149,237), new Color(255,215,0), Color.WHITE);
        currentTheme = lightTheme;
    }

    public static ThemeManager getInstance() {
        if (instance == null) instance = new ThemeManager();
        return instance;
    }

    public Theme getCurrentTheme() { return currentTheme; }
    public void toggleTheme() { currentTheme = (currentTheme == lightTheme) ? darkTheme : lightTheme; }
}
