package org.example;

import program.PseudoAssemblyWithStringProgram;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {


        String code = Files.readString(Paths.get("src/main/java/org/example/assemPart7.txt"));

        int numVirtualRegistersInt = 32;
        int numVirtualRegistersString = 32;
        String outputClassName = "MyLabProgram";
        String outputPackageNameDot = "mypackage";
        String classRootDir = System.getProperty("user.dir") + "/" + "target/classes";

        PseudoAssemblyWithStringProgram pseudoAssemblyWithStringProgram = new
                PseudoAssemblyWithStringProgram(
                code,
                outputClassName,
                outputPackageNameDot,
                classRootDir,
                numVirtualRegistersInt,
                numVirtualRegistersString
        );
        boolean parseSuccessful;
        parseSuccessful = pseudoAssemblyWithStringProgram.parse();
        if (parseSuccessful == true) {
// Creates a Java bytecode class file
            pseudoAssemblyWithStringProgram.generateBytecode();
// Run the Java bytecode class file and show output on the console
            PrintStream outstream = new PrintStream(System.out);
            pseudoAssemblyWithStringProgram.run(outstream);
        }
    } // end main method
}//end class Main