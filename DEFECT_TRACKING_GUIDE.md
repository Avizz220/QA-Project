# Step-by-Step Guide: Defect Tracking and Defect Density Analysis

This guide will help you track defects and calculate defect density for your Task Management module, even without access to professional defect tracking tools like Jira or Bugzilla.

## PART 1: SET UP A SIMPLE DEFECT TRACKING SPREADSHEET

### Step 1: Create a Defect Tracking Spreadsheet
1. Open Microsoft Excel or Google Sheets
2. Create a new spreadsheet
3. Name it "Task_Module_Defect_Tracking"
4. Set up the following columns:
   - Defect ID
   - Description
   - Severity
   - Component
   - Status
   - Date Found

### Step 2: Enter the Defects We've Already Identified
Enter the following defects into your spreadsheet:

| Defect ID | Description | Severity | Component | Status | Date Found |
|-----------|-------------|----------|-----------|--------|------------|
| DEF-001 | Missing Validation in TaskController | Major | TaskController | Open | 2025-09-21 |
| DEF-002 | Status Transition Error | Minor | TaskService | Open | 2025-09-21 |
| DEF-003 | Empty Title Validation | Major | TaskController | Open | 2025-09-21 |
| DEF-004 | Task Update Error | Major | TaskService | Open | 2025-09-21 |
| DEF-005 | Authentication Issue | Critical | TaskController | Open | 2025-09-21 |

### Step 3: Save Your Spreadsheet
Save this Excel/Google Sheet file to your project folder:
```
C:\Users\Avishka\Documents\QA_project\Task_Module_Defect_Tracking.xlsx
```

### Step 4: Take a Screenshot of Your Defect Tracking Spreadsheet
Take a screenshot of your completed defect tracking spreadsheet. This will be used in your report and presentation.

## PART 2: VERIFY THE LINE OF CODE COUNT

### Step 1: Verify the Lines of Code
We've already counted the lines of code for your Task module:
- TaskController.java: 106 LOC
- Task.java: 107 LOC
- TaskService.java: 113 LOC
- TaskRepository.java: 13 LOC
- Total: 339 LOC

### Step 2: Take a Screenshot of the Line Count Commands
Take a screenshot of the terminal showing the commands we used to count lines of code:
```
(Get-Content "c:\Users\Avishka\Documents\QA_project\backend\src\main\java\com\taskmanager\controller\TaskController.java" | Where-Object { $_ -match '\S' -and $_ -notmatch '^\s*//' }).Count

(Get-Content "c:\Users\Avishka\Documents\QA_project\backend\src\main\java\com\taskmanager\model\Task.java" | Where-Object { $_ -match '\S' -and $_ -notmatch '^\s*//' }).Count

(Get-Content "c:\Users\Avishka\Documents\QA_project\backend\src\main\java\com\taskmanager\service\TaskService.java" | Where-Object { $_ -match '\S' -and $_ -notmatch '^\s*//' }).Count

$repoPath = "c:\Users\Avishka\Documents\QA_project\backend\src\main\java\com\taskmanager\repository\TaskRepository.java"; if (Test-Path $repoPath) { (Get-Content $repoPath | Where-Object { $_ -match '\S' -and $_ -notmatch '^\s*//' }).Count }
```

## PART 3: CALCULATE DEFECT DENSITY

### Step 1: Calculate the KLOC
- Total Lines of Code: 339
- KLOC = 339 / 1000 = 0.339 KLOC

### Step 2: Calculate Defect Density
- Total Defects: 5
- Defect Density = Total Defects / KLOC = 5 / 0.339 = 14.75 defects per KLOC

### Step 3: Create a Visual Representation of the Calculation
You can create a simple calculation visual in your spreadsheet or on paper showing:
```
Defect Density = 5 defects / 0.339 KLOC = 14.75 defects/KLOC
```

Take a screenshot of this calculation.

## PART 4: CREATE A SIMPLE DEFECT DENSITY REPORT

### Step 1: Create a Report Document
Create a new Word document or Google Doc named "Task_Module_Defect_Density_Report.docx"

### Step 2: Include the Following Sections in Your Report

#### 1. Introduction
- Brief description of the Task Management module
- Purpose of defect density analysis

#### 2. Methodology
- How LOC was counted (line count approach)
- How defects were identified (review of test files)

#### 3. Defect Analysis
- Table showing the 5 defects with details
- Brief description of each defect

#### 4. Defect Density Calculation
- Show the calculation: 5 defects / 0.339 KLOC = 14.75 defects/KLOC

#### 5. Interpretation of Results
- Compare your defect density with industry standards (typically 1-25 defects per KLOC)
- Analyze what this means for your code quality

#### 6. Recommendations
- List 3-5 recommendations for improving code quality

### Step 3: Include Screenshots in Your Report
Insert the following screenshots into your report:
1. Project structure showing Task module files
2. Line count commands and results
3. Defect tracking spreadsheet
4. Defect density calculation

## PART 5: PREPARE FOR PRESENTATION

### Step 1: Create Presentation Slides
Create 5-7 slides that cover:
1. Title and introduction
2. Methodology for counting LOC and tracking defects
3. Defect analysis results
4. Defect density calculation
5. Recommendations

### Step 2: Practice Your Presentation
Practice explaining:
1. What defect density is and why it's important
2. How you identified and tracked defects
3. What your results mean for code quality
4. Your recommendations for improvement

## SCREENSHOTS TO INCLUDE IN YOUR SUBMISSION

1. **Screenshot 1**: Project structure showing Task module files
2. **Screenshot 2**: Terminal showing line count commands and results
3. **Screenshot 3**: Your completed defect tracking spreadsheet
4. **Screenshot 4**: Your defect density calculation
5. **Screenshot 5**: Your final defect density report document

## FINAL CHECKLIST

Ensure you have:
- [ ] Created a defect tracking spreadsheet
- [ ] Verified the line count for each component
- [ ] Calculated the defect density correctly
- [ ] Created a comprehensive report document
- [ ] Prepared presentation slides
- [ ] Taken all required screenshots

This completes your step-by-step guide for tracking defects and calculating defect density for your Task Management module.