# Financial-system
This repository contains a course project (a program for processing financial documents).

The project aims to create a program for processing payment documents and generating financial reports. To access the program, user authentication using a login and password is required. The program is designed to process three types of financial documents: invoices, orders and checks, all of them in text format (txt). The main purpose is to read information from these documents, compile statistics and provide a comprehensive financial overview.

Features User authentication: Access to the program is limited and requires entering a valid login and password.

Document processing: The program takes the path to a folder containing financial documents, reads the information and compiles statistics.

Document types: Three document types are supported: invoices, orders and checks. Each document type has its own structure and naming pattern.

Processing the current year: The program processes only files of the current year (2023).

Technical documentation: The code follows the C4 model for technical documentation.

Error Handling: Various checks have been implemented to ensure reliable execution.

Logging: The program generates logs and saves them in a separate file. The logs are divided into general information and error information.

Processing invalid files: After processing, all invalid files are moved to a separate folder.

Final statistics: A summary of statistics is saved in a separate file, including the total turnover for the year and the turnover for each document type.
