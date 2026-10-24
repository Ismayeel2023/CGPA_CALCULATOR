# CGPA Calculator

A Java console application that calculates the CGPA of every student in a class using **relative grading**: each student's grade in a subject depends on how they scored compared to the class median, not on fixed mark ranges.

## Features

- Handles any number of students and subjects
- Credit-weighted CGPA calculation
- Relative grades based on each subject's median mark
- Grade scale: O (10), A+ (9), A (8), B+ (7), B (6), C (5), U/R (0)
- Flags students with arrears (FAIL) or a clear result (PASS)

## How it works

1. Enter the number of students and subjects.
2. Enter the credits for each subject.
3. Enter each student's marks (out of 100).
4. For each subject, the program sorts the class marks, finds the median, and assigns grades relative to it.
5. CGPA = Σ(grade point × credits) / Σ(credits), shown with each student's per-subject grades and result.

## Run it

Requires Java 8 or later.

```bash
javac CGPACalculator.java
java CGPACalculator
```

## Tech

Java · `Scanner` for console input · arrays and sorting for median-based grading
