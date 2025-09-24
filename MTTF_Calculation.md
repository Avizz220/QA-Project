# Mean Time to Failure (MTTF) Calculation

## Method 1: Total Operating Time / Number of Failures

**Total Operating Time:** 
10 + 12 + 8 + 8 + 20 + 7 + 5 = 70 hours

**Number of Failures:** 
5 failures

**MTTF Calculation:**
MTTF = Total Operating Time / Number of Failures
MTTF = 70 hours / 5 failures
MTTF = 14 hours per failure

## Method 2: Average of Time to Failure Values

**Time to Failure Values:** 
8, 12, 18, 7, 5 hours

**MTTF Calculation:**
MTTF = (8 + 12 + 18 + 7 + 5) / 5
MTTF = 50 / 5
MTTF = 10 hours per failure

## Interpretation

    For our Task Management application, we estimate that a failure will occur, on average, every 14 hours of operation (using Method 1, which considers all testing time).

    This MTTF value of 14 hours indicates:
    - The system can run for approximately 14 hours before experiencing a failure
    - For a system running 24/7, we would expect approximately 1.7 failures per day
    - Maintenance activities should be scheduled at least every 14 hours to maintain system reliability