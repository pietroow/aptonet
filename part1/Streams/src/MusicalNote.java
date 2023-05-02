import java.util.Objects;

// MusicalNote.java
public class MusicalNote {
    Character pitch;
    boolean flat; //b
    boolean sharp; //#
    double duration;
    String dynamics;
    String articulation;

    MusicalNote(Character pitch, boolean flat, boolean sharp, double duration, String dynamics, String articulation) {
        this.pitch = pitch;
        this.flat = flat;
        this.sharp = sharp;
        this.duration = duration;
        this.dynamics = dynamics;
        this.articulation = articulation;
    }

    MusicalNote(MusicalNote musicalNote) {
        this.pitch = musicalNote.pitch;
        this.flat = musicalNote.flat;
        this.sharp = musicalNote.sharp;
        this.duration = musicalNote.duration;
        this.dynamics = musicalNote.dynamics;
        this.articulation = musicalNote.articulation;
    }


    public Character getPitch() {
        return pitch;
    }

    public boolean getFlat() {
        return flat;
    }

    public boolean getSharp() {
        return sharp;
    }

    public double getDuration() {
        return duration;
    }

    public String getDynamics() {
        return dynamics;
    }

    public String getArticulation() {
        return articulation;
    }

    public void setPitch(Character pitch) {
        this.pitch = pitch;
    }

    public void setFlat(boolean flat) {
        this.flat = flat;
    }

    public void setSharp(boolean sharp) {
        this.sharp = sharp;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setDynamics(String dynamics) {
        this.dynamics = dynamics;
    }

    public void setArticulation(String articulation) {
        this.articulation = articulation;
    }

    public boolean isSharpFlat() {
        return sharp && flat;
    }

    public boolean isForte() {
        return Objects.equals("forte", dynamics);
    }

    public MusicalNote setNoSharpFlat() {
        this.sharp = false;
        this.flat = false;
        return this;
    }

    @Override
    public String toString() {
        return "MusicalNote{" +
                "pitch=" + pitch +
                ", flat=" + flat +
                ", sharp=" + sharp +
                ", duration=" + duration +
                ", dynamics='" + dynamics + '\'' +
                ", articulation='" + articulation + '\'' +
                '}';
    }
}