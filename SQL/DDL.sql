DROP TABLE IF EXISTS Members CASCADE;
DROP TABLE IF EXISTS Trainers CASCADE;
DROP TABLE IF EXISTS Admins CASCADE;
DROP TABLE IF EXISTS Rooms CASCADE;
DROP TABLE IF EXISTS Bookings CASCADE;
DROP TABLE IF EXISTS Timeslots CASCADE;
DROP TABLE IF EXISTS Classes CASCADE;
DROP TABLE IF EXISTS Taking CASCADE;
DROP TABLE IF EXISTS Teaching CASCADE;
DROP TABLE IF EXISTS Availability CASCADE;
DROP TABLE IF EXISTS HasAvailability CASCADE;
DROP TABLE IF EXISTS IsBusy CASCADE;
DROP TABLE IF EXISTS HasTimeslot CASCADE;
DROP TABLE IF EXISTS Equipment CASCADE;
DROP TABLE IF EXISTS Maintains CASCADE;
DROP TABLE IF EXISTS FitnessGoals CASCADE;
DROP TABLE IF EXISTS HasGoals CASCADE;
DROP TABLE IF EXISTS HealthMetrics CASCADE;
DROP TABLE IF EXISTS HasMetric CASCADE;
DROP TABLE IF EXISTS Exercises CASCADE;
DROP TABLE IF EXISTS HasEquipment CASCADE;
DROP TABLE IF EXISTS Routines CASCADE;
DROP TABLE IF EXISTS InRoutine CASCADE;
DROP TABLE IF EXISTS HasRoutine CASCADE;
DROP TABLE IF EXISTS Invoices CASCADE;
DROP TABLE IF EXISTS Pays CASCADE;
DROP TABLE IF EXISTS Charges CASCADE;

DROP TYPE IF EXISTS DayOfWeek;
DROP TYPE IF EXISTS TimeOfDay;
DROP TYPE IF EXISTS ExerciseType;
DROP TYPE IF EXISTS EquipmentCondition;
DROP TYPE IF EXISTS EquipmentStatus;

CREATE TYPE DayOfWeek AS ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday');
CREATE TYPE TimeOfDay AS ENUM('Mornings', 'Afternoons');
CREATE TYPE EquipmentCondition AS ENUM('Broken, Needs Replacement', 'Poor', 'Decent', 'Good', 'Excellent', 'New');
CREATE TYPE EquipmentStatus AS ENUM('Available', 'In Use', 'Under Maintenance');
CREATE TYPE ExerciseType AS ENUM('CARDIO', 'STRENGTH', 'FLEXIBILITY', 'BALANCE');

CREATE TABLE Members (
    memberID Serial,
    fName text NOT NULL,
    lName text NOT NULL,
    email text UNIQUE NOT NULL,
    username text UNIQUE NOT NULL,
    password text NOT NULL,
    dateOfBirth date,
    PRIMARY KEY (memberID)
);

CREATE TABLE Trainers (
    trainerID Serial,
    fName text NOT NULL,
    lName text NOT NULL,
    email text UNIQUE NOT NULL,
    username text UNIQUE NOT NULL,
    password text NOT NULL,
    dateOfBirth date,
    PRIMARY KEY (trainerID)
);

CREATE TABLE Admins (
    adminID Serial,
    username text NOT NULL,
    email text UNIQUE NOT NULL,
    password text NOT NULL,
    PRIMARY KEY (adminID)
);

CREATE TABLE Timeslots (
    timeslotID Serial,
    startTime time NOT NULL,
    endTime time NOT NULL,
    PRIMARY KEY (timeslotID)
);

CREATE TABLE Classes (
    classID Serial,
    name text NOT NULL,
    dayOfWeek DayOfWeek NOT NULL,
    timeslotID int,
    type ExerciseType,
    public Boolean NOT NULL,
    cost Numeric NOT NULL,
    PRIMARY KEY (classID),
    CONSTRAINT fk_timeslotID
        FOREIGN KEY(timeslotID)
        REFERENCES Timeslots(timeslotID) ON DELETE CASCADE
);

CREATE TABLE Rooms (
    roomID Serial,
    roomName text NOT NULL,
    roomCapacity int NOT NULL,
    PRIMARY KEY (roomID)
);

CREATE TABLE Bookings (
    classID Serial,
    roomID int,
    adminID int,
    PRIMARY KEY (classID),
    CONSTRAINT fk_classID
        FOREIGN KEY(classID)
        REFERENCES Classes(classID) ON DELETE CASCADE,
    CONSTRAINT fk_roomID
        FOREIGN KEY(roomID)
        REFERENCES Rooms(roomID) ON DELETE CASCADE,
    CONSTRAINT fk_adminID
        FOREIGN KEY(adminID)
        REFERENCES Admins(adminID) ON DELETE CASCADE
);

CREATE TABLE Taking (
    entryID Serial,
    classID int,
    memberID int,
    PRIMARY KEY (entryID),
    CONSTRAINT fk_memberID
        FOREIGN KEY(memberID)
        REFERENCES Members(memberID) ON DELETE CASCADE,
    CONSTRAINT fk_classID
        FOREIGN KEY(classID)
        REFERENCES Classes(classID) ON DELETE CASCADE
);

CREATE TABLE Teaching (
    entryID Serial,
    classID int,
    trainerID int,
    PRIMARY KEY (entryID),
    CONSTRAINT fk_trainerID
        FOREIGN KEY(trainerID)
        REFERENCES Trainers(trainerID) ON DELETE CASCADE,
    CONSTRAINT fk_classID
        FOREIGN KEY(classID)
        REFERENCES Classes(classID) ON DELETE CASCADE
);

CREATE TABLE Availability (
	availabilityID Serial,
    dayOfWeek DayOfWeek NOT NULL,
    timeOfDay TimeOfDay NOT NULL,
    PRIMARY KEY (availabilityID)
);

CREATE TABLE HasTimeslot (
    timeslotID int,
    timeOfDay TimeOfDay NOT NULL,
    PRIMARY KEY (timeslotID),
    CONSTRAINT fk_timeslotID
        FOREIGN KEY(timeslotID)
        REFERENCES Timeslots(timeslotID) ON DELETE CASCADE
);

CREATE TABLE HasAvailability (
    entryID Serial,
    availabilityID int,
    trainerID int,
    PRIMARY KEY (entryID),
    CONSTRAINT fk_trainerID
        FOREIGN KEY(trainerID)
        REFERENCES Trainers(trainerID) ON DELETE CASCADE,
    CONSTRAINT fk_availabilityID
        FOREIGN KEY(availabilityID)
        REFERENCES Availability(availabilityID) ON DELETE CASCADE
);

CREATE TABLE IsBusy (
    entryID Serial,
    trainerID int,
    dayOfWeek DayOfWeek NOT NULL,
    timeslotID int,
    classID int,
    PRIMARY KEY (entryID),
    CONSTRAINT fk_trainerID
        FOREIGN KEY(trainerID)
        REFERENCES Trainers(trainerID) ON DELETE CASCADE,
    CONSTRAINT fk_timeslotID
        FOREIGN KEY(timeslotID)
        REFERENCES Timeslots(timeslotID) ON DELETE CASCADE,
    CONSTRAINT fk_classID
        FOREIGN KEY(classID)
        REFERENCES Classes(classID) ON DELETE CASCADE
);


CREATE TABLE Equipment (
    equipmentID Serial,
    name text NOT NULL,
    type ExerciseType NOT NULL,
    condition EquipmentCondition NOT NULL,
    status EquipmentStatus NOT NULL,
    PRIMARY KEY (equipmentID)
);

CREATE TABLE Maintains (
    equipmentID int,
    adminID int,
    PRIMARY KEY (equipmentID),
    CONSTRAINT fk_adminID
        FOREIGN KEY(adminID)
        REFERENCES Admins(adminID) ON DELETE CASCADE,
    CONSTRAINT fk_equipmentID
        FOREIGN KEY(equipmentID)
        REFERENCES Equipment(equipmentID) ON DELETE CASCADE
);

CREATE TABLE FitnessGoals (
    goalID Serial,
    goal text NOT NULL,
    dateSet date NOT NULL,
    dateAchieved date,
    PRIMARY KEY (goalID)
);

CREATE TABLE HasGoals (
    goalID int,
    memberID int,
    PRIMARY KEY (goalID),
    CONSTRAINT fk_memberID
        FOREIGN KEY(memberID)
        REFERENCES Members(memberID) ON DELETE CASCADE,
    CONSTRAINT fk_goalID
        FOREIGN KEY(goalID)
        REFERENCES FitnessGoals(goalID) ON DELETE CASCADE
);

CREATE TABLE HealthMetrics (
    metricID Serial,
    height int NOT NULL,
    weight int NOT NULL,
    bmi int NOT NULL,
    dateMeasured date NOT NULL,
    PRIMARY KEY (metricID)
);

CREATE TABLE HasMetric (
    metricID int,
    memberID int,
    PRIMARY KEY (metricID),
    CONSTRAINT fk_memberID
        FOREIGN KEY(memberID)
        REFERENCES Members(memberID) ON DELETE CASCADE,
    CONSTRAINT fk_metricID
        FOREIGN KEY(metricID)
        REFERENCES HealthMetrics(metricID) ON DELETE CASCADE
);

CREATE TABLE Exercises (
    exerciseID Serial,
    name text NOT NULL,
    description text NOT NULL,
    type ExerciseType,
    PRIMARY KEY (exerciseID)
);

CREATE TABLE HasEquipment (
    exerciseID int,
    equipmentID int,
    PRIMARY KEY (exerciseID),
    CONSTRAINT fk_equipmentID
        FOREIGN KEY(equipmentID)
        REFERENCES Equipment(equipmentID) ON DELETE CASCADE,
    CONSTRAINT fk_exerciseID
        FOREIGN KEY(exerciseID)
        REFERENCES Exercises(exerciseID) ON DELETE CASCADE
);

CREATE TABLE Routines (
    routineID Serial,
    name text NOT NULL,
    type ExerciseType,
    PRIMARY KEY (routineID)
);

CREATE TABLE HasRoutine (
    routineID int,
    memberID int,
    PRIMARY KEY (routineID),
    CONSTRAINT fk_memberID
        FOREIGN KEY(memberID)
        REFERENCES Members(memberID) ON DELETE CASCADE,
    CONSTRAINT fk_routineID
        FOREIGN KEY(routineID)
        REFERENCES Routines(routineID) ON DELETE CASCADE
);

CREATE TABLE InRoutine (
    entryID Serial,
    routineID int,
    exerciseID int,
    PRIMARY KEY (entryID),
    CONSTRAINT fk_routineID
        FOREIGN KEY(routineID)
        REFERENCES Routines(routineID) ON DELETE CASCADE,
    CONSTRAINT fk_exerciseID
        FOREIGN KEY(exerciseID)
        REFERENCES Exercises(exerciseID) ON DELETE CASCADE
);

CREATE TABLE Invoices (
    invoiceID Serial,
    amount int NOT NULL,
    dateIssued date NOT NULL,
    dateDue date NOT NULL,
    paid Boolean DEFAULT FALSE NOT NULL,
    PRIMARY KEY (invoiceID)
);

CREATE TABLE Pays (
    entryID Serial,
    invoiceID int,
    memberID int,
    PRIMARY KEY (entryID),
    CONSTRAINT fk_invoiceID
        FOREIGN KEY(invoiceID)
        REFERENCES Invoices(invoiceID) ON DELETE CASCADE,
    CONSTRAINT fk_memberID
        FOREIGN KEY(memberID)
        REFERENCES Members(memberID) ON DELETE CASCADE
);

CREATE TABLE Charges (
    chargeID Serial,
    invoiceID int,
    classID int,
    PRIMARY KEY (chargeID),
    CONSTRAINT fk_invoiceID
        FOREIGN KEY(invoiceID)
        REFERENCES Invoices(invoiceID) ON DELETE CASCADE,
    CONSTRAINT fk_classID
        FOREIGN KEY(classID)
        REFERENCES Classes(classID) ON DELETE CASCADE
);