INSERT INTO Members (fName, lName, email, username, password, dateOfBirth) VALUES
('John', 'Doe', 'JohnDoe@gmail.com', 'johndoe', 'password', '1990-01-01'),
('Jane', 'Smith', 'JaneSmith@gmail.com', 'janesmith', 'PASSWORD', '1995-05-10'),
('Michael', 'Johnson', 'MichaelJohnson@gmail.com', 'michaeljohnson', 'pAsSwoRd', '1988-09-15'),
('Emily', 'Brown', 'EmilyBrown@gmail.com', 'emilybrown', 'emilyemily', '1992-03-20'),
('David', 'Wilson', 'DavidWilson@gmail.com', 'davidwilson', 'wordpass', '1997-07-25');

INSERT INTO Trainers (fName, lName, email, username, password, dateOfBirth) VALUES
('Sarah', 'Johnson', 'SarahJohnson@gmail.com', 'sarahjohnson', 'trainerpass', '1985-06-12'),
('Mark', 'Davis', 'MarkDavis@gmail.com', 'markdavis', 'gym123', '1991-11-30'),
('Jessica', 'Wilson', 'JessicaWilson@gmail.com', 'jessicawilson', 'fitlife', '1987-04-05'),
('temp', 'temp', 'temp', 'temp', 'temp', '1990-01-01');

INSERT INTO Admins (username, email, password) VALUES
('Admin1', 'admin1@gmail.com', 'admin1pass'),
('Admin2', 'admin2@gmail.com', 'admin2pass'),
('Admin3', 'admin3@gmail.com', 'admin3pass');

INSERT INTO Rooms (roomName, roomCapacity) VALUES
('Cardio Room1', 20),
('Cardio Room2', 15),
('Pool', 10),
('Weight Room1', 25),
('Private Room1', 30);

INSERT INTO Availability (dayOfWeek, timeOfDay) VALUES
('Monday', 'Mornings'),
('Monday', 'Afternoons'),
('Tuesday', 'Mornings'),
('Tuesday', 'Afternoons'),
('Wednesday', 'Mornings'),
('Wednesday', 'Afternoons'),
('Thursday', 'Mornings'),
('Thursday', 'Afternoons'),
('Friday', 'Mornings'),
('Friday', 'Afternoons'),
('Saturday', 'Mornings'),
('Saturday', 'Afternoons'),
('Sunday', 'Mornings'),
('Sunday', 'Afternoons');

INSERT INTO Timeslots (startTime, endTime) VALUES
('06:00:00', '07:00:00'),
('07:00:00', '08:00:00'),
('08:00:00', '09:00:00'),
('09:00:00', '10:00:00'),
('10:00:00', '11:00:00'),
('11:00:00', '12:00:00'),
('12:00:00', '13:00:00'),
('13:00:00', '14:00:00'),
('14:00:00', '15:00:00'),
('15:00:00', '16:00:00'),
('16:00:00', '17:00:00'),
('17:00:00', '18:00:00');

INSERT INTO HasTimeslot (timeOfDay, timeslotID) VALUES
('Mornings', 1),
('Mornings', 2),
('Mornings', 3),
('Mornings', 4),
('Mornings', 5),
('Mornings', 6),
('Afternoons', 7),
('Afternoons', 8),
('Afternoons', 9),
('Afternoons', 10),
('Afternoons', 11),
('Afternoons', 12);

INSERT INTO Classes (name, dayOfWeek, timeslotID, type, public, cost) VALUES
('Cardio', 'Monday', 4, 'CARDIO', 'TRUE', 65.00),
('Cardio', 'Tuesday', 5, 'CARDIO', 'TRUE', 65.00),
('Cardio', 'Wednesday', 6, 'CARDIO', 'TRUE', 65.00),
('Strength', 'Thursday', 4, 'STRENGTH', 'TRUE', 75.00),
('Strength', 'Friday', 5, 'STRENGTH', 'TRUE', 75.00),
('Strength', 'Saturday', 6, 'STRENGTH', 'TRUE', 75.00),
('Balance', 'Sunday', 4, 'BALANCE', 'TRUE', 50.00),
('Balance', 'Monday', 5, 'BALANCE', 'TRUE', 50.00),
('Balance', 'Monday', 6, 'BALANCE', 'TRUE', 50.00);

INSERT INTO Bookings (classID, roomID, adminID) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 5, 3);

INSERT INTO Taking (classID, memberID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 1),
(8, 1),
(9, 1);

INSERT INTO Teaching (classID, trainerID) VALUES
(1, 1),
(2, 1),
(3, 2);


INSERT INTO HasAvailability (availabilityID, trainerID) VALUES
(1, 1),
(3, 1),
(5, 1),
(7, 1),
(9, 1),
(2, 2),
(4, 2),
(6, 2),
(8, 2),
(10, 2),
(11, 3),
(12, 3),
(13, 3),
(14, 3);

INSERT INTO IsBusy (trainerID, dayOfWeek, timeslotID) VALUES
(1, 'Monday', 4),
(1, 'Tuesday', 5),
(2, 'Wednesday', 6);

INSERT INTO Equipment (name, type, condition, status) VALUES
('Treadmill', 'CARDIO', 'Decent', 'Available'),
('Stationary Bike', 'CARDIO', 'Good', 'Available'),
('Elliptical', 'CARDIO', 'Good', 'Available'),
('Bench Press', 'STRENGTH', 'Broken, Needs Replacement', 'Available'),
('Dumbbells', 'STRENGTH', 'Decent', 'Available'),
('Pool Noodles', 'CARDIO', 'Poor', 'Available');

INSERT INTO Maintains (equipmentID, adminID) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 3);

INSERT INTO FitnessGoals (goal, dateSet, dateAchieved) VALUES
('Lose 10 pounds', '2023-09-01', '2023-10-01'),
('Gain muscle', '2023-09-01', '2023-10-01'),
('Improve flexibility', '2023-09-01', '2023-10-01'),
('Improve balance', '2023-09-01', '2023-10-01'),
('Improve strength', '2023-09-01', '2023-10-01'),
('Increase endurance', '2023-09-01', '2023-10-01'),
('Reduce body fat percentage', '2023-09-01', '2023-10-01'),
('Improve cardiovascular health', '2023-09-01', '2023-10-01');

INSERT INTO FitnessGoals (goal, dateSet) VALUES
('Enhance athletic performance', '2023-09-01'),
('Improve flexibility', '2023-09-01');

INSERT INTO HasGoals (goalID, memberID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1);

INSERT INTO HealthMetrics (dateMeasured, weight, height, bmi) VALUES
('2023-09-01', 150, 5.5, 100),
('2023-09-01', 130, 5.0, 80),
('2023-09-01', 160, 5.7, 110),
('2023-09-01', 140, 5.3, 90),
('2023-09-01', 170, 5.9, 120),
('2023-10-01', 160, 5.6, 100),
('2023-11-01', 165, 5.7, 100),
('2023-12-01', 163, 5.9, 100);

INSERT INTO HasMetric (metricID, memberID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 1),
(8, 1);

INSERT INTO Exercises (name, description, type) VALUES
('Pushups', 'Push body up and down', 'STRENGTH'),
('Situps', 'Lay on back and sit up', 'STRENGTH'),
('Squats', 'Bend knees and stand up', 'STRENGTH'),
('Jumping Jacks', 'Jump and spread arms and legs', 'CARDIO'),
('Running', 'Move legs quickly', 'CARDIO'),
('Cycling', 'Pedal bike', 'CARDIO'),
('Swimming', 'Move arms and legs in water', 'CARDIO'),
('Weight shifts', 'Shift weight from side to side', 'BALANCE'),
('Single-leg balance', 'Stand on one leg while raising and loweing the other', 'BALANCE');

INSERT INTO HasEquipment (exerciseID, equipmentID) VALUES
(1, 5),
(2, 5),
(3, 5),
(4, 1),
(5, 1),
(6, 2),
(7, 6);

INSERT INTO Routines (name, type) VALUES
('Strength Training', 'STRENGTH'),
('Cardio Training', 'CARDIO'),
('Strength Training', 'STRENGTH'),
('Cardio Training', 'CARDIO'),
('Strength Training', 'STRENGTH'),
('Balance Training', 'BALANCE');

INSERT INTO InRoutine (routineID, exerciseID) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 1),
(3, 2),
(3, 3),
(4, 4),
(4, 5),
(4, 6),
(5, 7),
(5, 8),
(6, 8),
(6, 9);

INSERT INTO HasRoutine (routineID, memberID) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4),
(6, 1);

INSERT INTO Invoices (amount, dateIssued, dateDue, paid) VALUES
(65.00, '2023-09-01', '2023-10-01', TRUE);

INSERT INTO Invoices (amount, dateIssued, dateDue) VALUES
(65.00, '2023-09-01', '2023-10-01'),
(65.00, '2023-09-01', '2023-10-01'),
(75.00, '2023-09-01', '2023-10-01'),
(75.00, '2023-09-01', '2023-10-01'),
(75.00, '2023-09-01', '2023-10-01'),
(100.00, '2023-10-01', '2023-11-01');

INSERT INTO Pays (invoiceID, memberID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 1);

INSERT INTO Charges (invoiceID, classID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(7, 8);