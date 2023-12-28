# Functions Lab: Classifying Relations

## Overview
This Java application helps in classifying relations as regular functions, onto functions, one-to-one functions, bijections, or identifying them as non-functions. The program reads integers from standard input and analyzes the relations based on set theory principles. This project is designed to help learners gain a deeper understanding of the different types of functions and how they are determined.

## Features
- **Input Parsing**: Reads and interprets data from standard input, including domains, codomains, and relations.
- **Set Notation Formatting**: Formats and displays the domain, codomain, and relations using set notation.
- **Function Classification**: Identifies whether a given relation represents a regular function, an onto function, a one-to-one function, a bijection, or if it's not a function at all.

## Input Format
- The first line contains the members of the domain, separated by whitespace.
- The second line contains the members of the codomain.
- The third line lists ordered pairs of the relation, separated by whitespace.

## Example
Input:  
>1 2 3  
>4 8 2  
>1 4 2 4 3 8  

Output:  
>DOMAIN: { 1, 2, 3 }  
>CODOMAIN: { 4, 8, 2 }  
>RELATION: { (1,4), (2,4), (3,8) }  
>This is a function.  
>It is not onto.  
>It is not one-to-one.  
>It is not a bijection.  

## Usage
1. Compile the Java code.
1. Run the program.
2. Enter the domain, codomain, and relation data as per the specified format.
3. The program will classify the relation and print the results.

## Contributing
Contributions for extending functionality, refining the classification logic, or improving the codebase are welcome. Please ensure adherence to the existing coding style and standards.
