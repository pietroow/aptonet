import java.util.*;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// tip: each public class is put in its own file
public class Main {
    // tip: arguments are passed via the field below this editor

    private static final List<Character> VALID_NOTES = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G');

    public static void main(String[] args) {

        // 1 quarter = 1 beat
        // 1 whole = 2 halfs = 4 quarter = 8 eighth

        MusicalNote Cwhole = new MusicalNote('C', false, false, 4, null, null);
        MusicalNote Dwhole = new MusicalNote('D', false, false, 4, null, null);
        MusicalNote Ewhole = new MusicalNote('E', false, false, 4, null, null);
        MusicalNote Fwhole = new MusicalNote('F', false, false, 4, null, null);
        MusicalNote Gwhole = new MusicalNote('G', false, false, 4, null, null);
        MusicalNote Awhole = new MusicalNote('A', false, false, 4, null, null);
        MusicalNote Bwhole = new MusicalNote('B', false, false, 4, null, null);

        MusicalNote Chalf = new MusicalNote('C', false, false, 2, null, null);
        MusicalNote Dhalf = new MusicalNote('D', false, false, 2, null, null);
        MusicalNote Ehalf = new MusicalNote('E', false, false, 2, null, null);
        MusicalNote Fhalf = new MusicalNote('F', false, false, 2, null, null);
        MusicalNote Ghalf = new MusicalNote('G', false, false, 2, null, null);
        MusicalNote Ahalf = new MusicalNote('A', false, false, 2, null, null);
        MusicalNote Bhalf = new MusicalNote('B', false, false, 2, null, null);

        MusicalNote Cquarter = new MusicalNote('C', false, false, 1, "piano", null);
        MusicalNote Dquarter = new MusicalNote('D', false, false, 1, null, null);
        MusicalNote Equarter = new MusicalNote('E', false, false, 1, null, null);
        MusicalNote Fquarter = new MusicalNote('F', false, false, 1, null, null);
        MusicalNote Gquarter = new MusicalNote('G', false, false, 1, null, null);
        MusicalNote Aquarter = new MusicalNote('A', false, false, 1, null, null);
        MusicalNote Bquarter = new MusicalNote('B', false, false, 1, "forte", null);
        MusicalNote Hquarter = new MusicalNote('M', false, false, 1, null, null);

        MusicalNote Ceighth = new MusicalNote('C', false, false, 0.5, "forte", null);
        MusicalNote Deighth = new MusicalNote('D', false, false, 0.5, null, null);
        MusicalNote Eeighth = new MusicalNote('E', false, false, 0.5, null, null);
        MusicalNote Feighth = new MusicalNote('F', false, false, 0.5, null, null);
        MusicalNote Geighth = new MusicalNote('G', false, false, 0.5, null, null);
        MusicalNote Aeighth = new MusicalNote('A', false, false, 0.5, null, null);
        MusicalNote Beighth = new MusicalNote('B', false, false, 0.5, "piano", null);

        MusicalNote CsharpQuarter = new MusicalNote('C', false, true, 1, null, null);
        MusicalNote DflatQuarter = new MusicalNote('D', true, false, 1, null, null);
        MusicalNote EflatQuarter = new MusicalNote('E', true, false, 1, null, null);
        MusicalNote FsharpQuarter = new MusicalNote('F', false, true, 1, null, null);
        MusicalNote GsharpQuarter = new MusicalNote('G', false, true, 1, null, null);
        MusicalNote AflatQuarter = new MusicalNote('A', true, false, 1, null, null);
        MusicalNote BflatQuarter = new MusicalNote('B', true, false, 1, null, null);

        MusicalNote GflatSharpQuarter = new MusicalNote('G', true, true, 1, null, null);
        MusicalNote AflatSharpQuarter = new MusicalNote('A', true, true, 1, null, null);

        MusicalNote silenceWhole = new MusicalNote(null, false, false, 4, null, null);
        MusicalNote silenceHalf = new MusicalNote(null, false, false, 2, null, null);
        MusicalNote silenceQuarter = new MusicalNote(null, false, false, 1, null, null);
        MusicalNote silenceEighth = new MusicalNote(null, false, false, 0.5, null, null);
        MusicalNote silenceFlatHalf = new MusicalNote(null, true, false, 2, null, null);


        Stream<MusicalNote> instrument1 = Stream.of(Cquarter, Dquarter, Fhalf, silenceWhole, Bquarter, Dquarter, Ehalf); //Loud
        Stream<MusicalNote> instrument2 = Stream.of(Cquarter, Ceighth, Deighth, Ehalf, Bwhole, Deighth, Beighth, DflatQuarter, Ehalf); //Soft
        Stream<MusicalNote> instrument3 = Stream.of(Cquarter, Ceighth, Deighth, Ehalf, Bwhole, Deighth, Deighth, DflatQuarter, Ehalf); //Loud
        Stream<MusicalNote> instrument4 = Stream.of(Bquarter, Aeighth, Feighth, Dhalf, silenceHalf, GflatSharpQuarter, AflatSharpQuarter, Cquarter, Deighth, Deighth, Ehalf);//soft
        Stream<MusicalNote> instrument5 = Stream.of(Bquarter, Geighth, Feighth, silenceHalf, Ceighth, Ceighth, Ceighth, Ceighth, Beighth, Beighth, Beighth, Beighth, Hquarter, EflatQuarter, Fquarter, FsharpQuarter); //SOft
        Stream<MusicalNote> instrument6 = Stream.of(Aquarter, Aeighth, Deighth, silenceFlatHalf, Bwhole, Deighth, Deighth, DflatQuarter, Ehalf, Ceighth, Ceighth);//Loud

//        replaceSilenceNote(instrument5);
//        beats(instrument1, 5);
        instrument(instrument6);

        System.out.println("I LOVE MUSIC");

    }

    /*
    We have 7 notes A,B,C,D,E,F,G
    there is no M note, since that is an error, replace the note H with a silence of the same duration

    //Stream<MusicalNote> instrument5 = Stream.of(Bquarter, Geighth, Feighth, silenceHalf, Ceighth, Ceighth, Ceighth, Ceighth, Beighth, Beighth, Beighth, Beighth, Hquarter      , EflatQuarter, Fquarter, FsharpQuarter); //SOft
    //Stream<MusicalNote> instrument5 = Stream.of(Bquarter, Geighth, Feighth, silenceHalf, Ceighth, Ceighth, Ceighth, Ceighth, Beighth, Beighth, Beighth, Beighth, SILENCEQUARTER, Equarter,     Fquarter, Fquarter);

    Generalize if I introduce any wrong note as
    MusicalNote Xeighth = new MusicalNote('X',false, false,0.5,"piano", null);
    the same formula should replace Xeight for silenceEighth

    MusicalNote Hquarter       = new MusicalNote('M', false, false, 1, null, null);
    MusicalNote silenceQuarter = new MusicalNote(null, false, false, 1, null, null);
    MusicalNote silenceEighth = new MusicalNote(null, false, false, 0.5, null, null);

    MusicalNote EflatQuarter = new MusicalNote('E', true, false, 1, null, null);
    MusicalNote Equarter = new MusicalNote('E', false, false, 1, null, null);
     */
    private static Stream<MusicalNote> replaceSilenceNote(Stream<MusicalNote> instrument5) {
        return instrument5.map(musicalNote -> isPitchValid(musicalNote.pitch)
                ? musicalNote
                : new MusicalNote(null, musicalNote.flat, musicalNote.sharp, musicalNote.duration, musicalNote.dynamics, musicalNote.articulation));
    }

    private static boolean isPitchValid(Character pitch) {
        return Objects.nonNull(pitch) && VALID_NOTES.contains(pitch);
    }

    /*--------------------------------*/

    /*
    We have either flat or sharp notes, there are no flat sharp notes, so replace those notes with no sharps or flats. (Replace with VALUES of the notes, not the names)
    Generalize this rule.
    Example
    Instrument 4 = Stream.of(Bquarter,Aeighth,Feighth,Dhalf,silenceHalf,GflatSharpQuarter,AflatSharpQuarter,Cquarter,Deighth,Deighth,Ehalf);
    would be
    Instrument 4 = Stream.of(Bquarter,Aeighth,Feighth,Dhalf,silenceHalf,GQuarter,         AQuarter,Cquarter,Deighth,Deighth,Ehalf);

    MusicalNote GflatSharpQuarter = new MusicalNote('G', true, true, 1, null, null);
    MusicalNote Gquarter          = new MusicalNote('G', false, false, 1, null, null);

    MusicalNote AflatSharpQuarter = new MusicalNote('A', true, true, 1, null, null);
    MusicalNote Aquarter          = new MusicalNote('A', false, false, 1, null, null);
    */
    private static Stream<MusicalNote> replacseSilenceNote(Stream<MusicalNote> instrument4) {
        return instrument4
                .filter(MusicalNote::isSharpFlat)
                .map(MusicalNote::setNoSharpFlat);
    }

    /*--------------------------------*/

    /*
    A dynamic is how loud or soft a note should sound. Where piano is soft and forte is loud.
    A dynamic is marked only once and then goes with the same value until a new dynamic is encountered.
    For instance, if I have the notes: A(piano), B,C,D,E (forte),G ,C,D. Where A is piano and E is forte. B,C,D,E should also be piano and G,C,D should be forte even if they are not labeled.
    Now imagine that all instruments are playing, which ones are going to finish with a loud last note?
    Solution: Instrument 1,3 and 6
    Generalize this rule.
    */
    private static boolean isLastNoteLoud(Stream<MusicalNote> instrument) {
        return instrument
                .filter(note -> Objects.nonNull(note.dynamics))
                .reduce((first, second) -> second)
                .map(MusicalNote::isForte)
                .orElse(false);
    }

    /*--------------------------------*/

    /*
    A 4/4 meassure has 4 quarters, adding to 4 of duration. Here we should have 3 meassures, that is 12 of duration.
    Add the duration of each instrument and find the one that has a an 'extra' note and how long is that note.
    Solution instrument 6 with and eighth note, that is 0.5 extra of duration.
    Generalize this rule to any number of meassures making sure all instruments have same duration.

    new MusicalNote('A', false, false, 1, null, null);
    new MusicalNote('A', false, false, 0.5, null, null);
    new MusicalNote('D', false, false, 0.5, null, null);
    new MusicalNote(null, true, false, 2, null, null);
    new MusicalNote('B', false, false, 4, null, null);
    new MusicalNote('D', false, false, 0.5, null, null);
    new MusicalNote('D', false, false, 0.5, null, null);
    new MusicalNote('D', true, false, 1, null, null);
    new MusicalNote('E', false, false, 2, null, null);
    new MusicalNote('C', false, false, 0.5, "forte", null);
    */
    private static void instrument(Stream<MusicalNote> instrument) {
        DoubleAdder doubleAdder = new DoubleAdder();
        Map<Double, MusicalNote> sumMap = instrument.collect(Collectors.toMap(k -> {
            doubleAdder.add(k.duration);
            return doubleAdder.doubleValue();
        }, v -> v, (x, y) -> y, LinkedHashMap::new));

        List<MusicalNote> extraNotes = sumMap.keySet().stream()
                .filter(duration -> duration > 12)
                .map(sumMap::get)
                .toList();

        System.out.println("Total instrument duration -> " + doubleAdder.doubleValue());
        System.out.println("Extra duration from 12 -> " + (doubleAdder.doubleValue() - 12));
        extraNotes.forEach(System.out::println);
    }

    /*--------------------------------*/

    /*
    A beat is 1 quarter, that is 1 of duration.
    Print the notes that each instrument should be playing at X beat, aka, duration.
    For example at beat 1 instrument 1,2 and 3 are playing C while instrument 4,5,6 are playing B.
    what would they be playing at beat 7?
    Note that it can be silences, meaning there is no note playing at given time by that instrument.
    Also note that print whether the note is flat or sharp.
    In case of having eighth notes, then 2 notes should be played at X beat.
    Generalize this rule.

    MusicalNote Cquarter     = new MusicalNote('C', false, false, 1, "piano", null);
    MusicalNote Dquarter     = new MusicalNote('D', false, false, 1, null, null);
    MusicalNote Fhalf        = new MusicalNote('F', false, false, 2, null, null);
    MusicalNote silenceWhole = new MusicalNote(null, false, false, 4, null, null);
    MusicalNote Bquarter     = new MusicalNote('B', false, false, 1, "forte", null);
    MusicalNote Dquarter     = new MusicalNote('D', false, false, 1, null, null);
    MusicalNote Ehalf        = new MusicalNote('E', false, false, 2, null, null);

*/
    private static void beats(Stream<MusicalNote> instrument, int beat) {
        DoubleAdder doubleAdder = new DoubleAdder();
        Map<Double, MusicalNote> sumMap = instrument.collect(Collectors.toMap(k -> {
            double current = doubleAdder.doubleValue();
            doubleAdder.add(k.duration);
            return current;
        }, v -> v, (x, y) -> y, LinkedHashMap::new));

        double beatTechno = (double) beat - 1;
        MusicalNote lastNote = sumMap.getOrDefault(beatTechno, getInterval(sumMap, beat));
        System.out.println(lastNote);

        MusicalNote possibleNoteAtQuarterBeat = sumMap.getOrDefault(beat + 0.5, null);
        if (possibleNoteAtQuarterBeat != null && possibleNoteAtQuarterBeat.getDuration() == 0.5) {
            System.out.println(possibleNoteAtQuarterBeat);
        }
    }

    private static MusicalNote getInterval(Map<Double, MusicalNote> sumMap, double beat) {
        return sumMap.keySet().stream()
                .filter(note -> note < beat)
                .reduce((a, b) -> b)
                .map(o -> sumMap.get(beat))
                .orElse(null);
    }

}