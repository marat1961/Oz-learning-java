package Oz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

class Result {
    String line;
    DecimalFormat df;
    int sentences;
    int words;
    int chars;
    int syllables;
    int polysyllables;
    boolean ARI = false;
    boolean FK = false;
    boolean SMOG = false;
    boolean CL = false;

    Result(String line) {
        this.line = line;
        df = new DecimalFormat("0.00");
    }

    public void processText() {

        countText();
        String action = printState();
        System.out.println();
        setFlags(action);
        double s = 0;
        int n = 0;
        if (ARI) {
            s = s + AutomatedReadabilityIndex();
            n = n + 1;
        }
        if (FK) {
            s = s + FleschKincaidReadabilityTests();
            n = n + 1;
        }
        if (SMOG) {
            s = s + SimpleMeasureOfGobbledygook();
            n = n + 1;
        }
        if (CL) {
            s = s + ColemanLiauIndex();
            n = n + 1;
        }
        System.out.println();
        double yer = s / n;
        System.out.printf("This text should be understood in average by %.2f-year-olds\n", yer);
    }

    private void countText() {
        String[] sentence = line.split("[!.?]");
        sentences = sentence.length;
        words = 0;
        chars = 0;
        String[] words = line.split("\\s");
        for (String w : words) {
            int wl = 0;
            for (int i = 0; i < w.length(); i++) {
                char ch = w.charAt(i);
                if (ch > ' ') {
                    wl = wl + 1;
                }
            }
            if (wl > 0) {
                this.words = this.words + 1;
                chars = chars + wl;
            }
            int sc = calcSyllables(w);
            syllables = syllables + sc;
            if (sc > 2) {
                polysyllables = polysyllables + 1;
            }
        }
    }

    private void setFlags(String s) {
        switch (s) {
            case "all":
                ARI = true;
                FK = true;
                SMOG = true;
                CL = true;
                break;
            case "ARI":
                ARI = true;
                break;
            case "FK":
                FK = true;
                break;
            case "SMOG":
                SMOG = true;
                break;
            case "CL":
                CL = true;
                break;
            default:
                break;
        }
    }

    private double AutomatedReadabilityIndex() {
        double score = 4.71 * ((double) chars / (double) words) + 0.5 * ((double) words / (double) sentences) - 21.43;
        String age = getAge(score);
        System.out.printf("Automated Readability Index: %.2f (about %s-year-olds)\n", score, age);
        return score;
    }

    private double FleschKincaidReadabilityTests() {
        double score = 0.39 * words / sentences + 11.8 * syllables / words - 15.59;
        String age = getAge(score);
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n", score, age);
        return score;
    }

    private double SimpleMeasureOfGobbledygook() {
        double score = 1.043 * Math.sqrt(polysyllables * 30 / sentences) + 3.1291;
        String age = getAge(score);
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).\n", score, age);
        return score;
    }

    private double ColemanLiauIndex() {
        double l = (double) chars / words * 100;
        double s = (double) sentences / words * 100;
        double score = 0.0588 * l - 0.296 * s - 15.8;
        String age = getAge(score);
        System.out.printf("Coleman–Liau index: %.2f (about %s-year-olds).\n", score, age);
        return score;
    }

    private String printState() {
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + chars);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        final Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

    public static int calcSyllables(final String s) {
        String lc = s.toLowerCase().replaceAll("[.?!]$", "");
        String w = lc
                .replaceAll("[e]$", "")
                .replaceAll("[aeiouy]{2,}", "a")
                .replaceAll("[^aeiouy]", "");
        return Math.max(1, w.length());
    }

    private String getAge(double score) {
        int i = (int) Math.round(score);
        switch (i) {
            case 1:
                return "6";
            case 2:
                return "7";
            case 3:
                return "9";
            case 4:
                return "10";
            case 5:
                return "11";
            case 6:
                return "12";
            case 7:
                return "13";
            case 8:
                return "14";
            case 9:
                return "15";
            case 10:
                return "16";
            case 11:
                return "17";
            case 12:
                return "18";
            case 13:
                return "24";
            default:
                return "25";
        }
    }

}

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];
        File file = new File(fileName);
        Result r = new Result(readFileAsString(fileName));
        r.processText();
    }

    public static String readFileAsString(String fileName) {
        String r = "";
        try {
            r = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }

}