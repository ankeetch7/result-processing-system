-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2021 at 12:31 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `resultsystem_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `exams`
--

CREATE TABLE `exams` (
  `exam_id` int(11) NOT NULL,
  `exam_name` varchar(100) NOT NULL,
  `exam_start_date` varchar(10) NOT NULL,
  `exam_end_date` varchar(10) NOT NULL,
  `exam_desc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exams`
--

INSERT INTO `exams` (`exam_id`, `exam_name`, `exam_start_date`, `exam_end_date`, `exam_desc`) VALUES
(1, 'First Terminal Exam', '2078/03/16', '2078/03/20', 'This is first terminal examination.'),
(2, 'Second Terminal Exam', '2078/06/18', '2078/06/22', 'This is second terminal examination.'),
(3, 'Third Terminal Exam', '2078/09/20', '2078/09/24', 'This is third terminal examination.'),
(4, 'Final Terminal Exam', '2078/12/24', '2078/12/28', 'This is final terminal examination.'),
(5, 'First Terminal Exam', '2079/03/21', '2079/03/25', 'This is first teminal examination.'),
(6, 'Second Terminal Exam', '2079/06/12', '2079/06/16', 'This is second terminal examination.');

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE `grades` (
  `g_id` int(11) NOT NULL,
  `grade_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`g_id`, `grade_name`) VALUES
(1, 'Nursery'),
(2, 'LKG'),
(3, 'KG'),
(4, 'One'),
(5, 'Two'),
(6, 'Three'),
(7, 'Four'),
(8, 'Five');

-- --------------------------------------------------------

--
-- Table structure for table `logins`
--

CREATE TABLE `logins` (
  `login_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logins`
--

INSERT INTO `logins` (`login_id`, `username`, `password`, `role_id`) VALUES
(1, 'ankeet77', '21232f297a57a5a743894a0e4a801fc3', 1),
(2, 'aone', 'ee11cbb19052e40b07aac0ca060c23ee', 2);

-- --------------------------------------------------------

--
-- Table structure for table `marks_obt`
--

CREATE TABLE `marks_obt` (
  `id` int(11) NOT NULL,
  `english` int(11) DEFAULT NULL,
  `nepali` int(11) DEFAULT NULL,
  `maths` int(11) DEFAULT NULL,
  `science` int(11) DEFAULT NULL,
  `gk` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `grade_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `marks_obt`
--

INSERT INTO `marks_obt` (`id`, `english`, `nepali`, `maths`, `science`, `gk`, `student_id`, `grade_id`) VALUES
(1, 99, 99, 99, 99, 99, 5, 8),
(2, 85, 86, 91, 98, 89, 6, 8),
(3, 78, 86, 91, 92, 88, 7, 5),
(4, 75, 88, 68, 0, 0, 8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `results`
--

CREATE TABLE `results` (
  `result_id` int(11) NOT NULL,
  `g_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `marks_scored` int(11) NOT NULL,
  `remarks` varchar(20) DEFAULT NULL,
  `result_date` varchar(100) NOT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `results`
--

INSERT INTO `results` (`result_id`, `g_id`, `student_id`, `marks_scored`, `remarks`, `result_date`, `subject_id`, `exam_id`) VALUES
(1, 8, 5, 89, 'Very Good', '2078/03/30', 31, 1),
(2, 8, 5, 88, 'Very Good', '2078/03/30', 32, 1),
(3, 8, 5, 96, 'Very Good', '2078/03/30', 33, 1),
(4, 8, 5, 99, 'Very Good', '2078/03/30', 34, 1),
(5, 8, 5, 66, 'Good', '2078/03/30', 35, 1),
(6, 8, 5, 91, 'Very Good', '2078/06/25', 31, 6),
(7, 8, 5, 93, 'Very Good', '2078/06/25', 32, 6),
(8, 8, 5, 96, 'Very Good', '2078/06/25', 33, 6),
(9, 8, 5, 90, 'Very Good', '2078/06/25', 34, 6),
(10, 8, 5, 98, 'Very Good', '2078/06/25', 35, 6);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `roll_no` varchar(10) DEFAULT NULL,
  `first_name` varchar(20) NOT NULL,
  `middle_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `father_name` varchar(50) NOT NULL,
  `mother_name` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `parent_phone` varchar(13) NOT NULL,
  `parent_email` varchar(45) NOT NULL,
  `picture` text DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_id`, `roll_no`, `first_name`, `middle_name`, `last_name`, `dob`, `gender`, `father_name`, `mother_name`, `address`, `parent_phone`, `parent_email`, `picture`, `g_id`) VALUES
(5, '8145/17', 'Ankit', '', 'Chamlagain', '2056/04/12', 'Male', 'Surya Prasad Chamlagain', 'Bhuwa Devi Dhimal', 'Kanakai-6, Japa', '9815984110', 'bhuwa@gmail.com', 'C:\\Users\\Ankeet\\Documents\\NetBeansProjects\\ResultMgtSystem\\src\\Images\\&flix.jpg', 8),
(6, '8144/17', 'Shraddha', '', 'Khadka', '2055/12/28', 'Female', 'Sraddha Father', 'Shraddha Mother', 'Kanakai-6, Jhapa', '9863254120', 'shraddhamother@gmail.com', 'C:\\Users\\Ankeet\\Documents\\NetBeansProjects\\ResultMgtSystem\\src\\Images\\geosuper.png', 8),
(7, '7929/17', 'Raja', 'Ram', 'Lamichhane', '2057/01/29', 'Male', 'Gajraj Lamichhane', 'Bhanuka Lamichhane', 'Hetauda', '9865210210', 'raja@gmail.com', 'C:\\Users\\Ankeet\\Documents\\NetBeansProjects\\ResultMgtSystem\\src\\Images\\ytdvslbry.jpg', 5),
(8, '8162/22', 'Ram', '', 'Adhikari', '2060/12/06', 'Male', 'Ram Father Name', 'Ram Mother Name', 'Birtanagar, Morang', '9878458520', 'ramfather@gmail.com', 'C:\\Users\\Ankeet\\Documents\\NetBeansProjects\\ResultMgtSystem\\src\\Images\\Result ER Diagram.png', 1);

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(100) NOT NULL,
  `full_marks` varchar(5) DEFAULT NULL,
  `pass_marks` varchar(5) DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`subject_id`, `subject_name`, `full_marks`, `pass_marks`, `g_id`) VALUES
(1, 'English', '100', '40', 1),
(2, 'Nepali', '100', '40', 1),
(3, 'Maths', '100', '40', 1),
(4, 'English', '100', '40', 2),
(5, 'Nepali', '100', '40', 2),
(6, 'Maths', '100', '40', 2),
(7, 'English', '100', '40', 3),
(8, 'Nepali', '100', '40', 3),
(9, 'Maths', '100', '40', 3),
(10, 'English', '100', '40', 4),
(11, 'Nepali', '100', '40', 4),
(12, 'Maths', '100', '40', 4),
(13, 'Science', '100', '40', 4),
(14, 'GK', '100', '40', 4),
(15, 'English', '100', '40', 5),
(16, 'Nepali', '100', '40', 5),
(17, 'Maths', '100', '40', 5),
(18, 'Science', '100', '40', 5),
(19, 'GK', '100', '40', 5),
(20, 'English', '100', '40', 6),
(21, 'Nepali', '100', '40', 6),
(22, 'Maths', '100', '40', 6),
(24, 'Science', '100', '40', 6),
(25, 'GK', '100', '40', 6),
(26, 'English', '100', '40', 7),
(27, 'Nepali', '100', '40', 7),
(28, 'Maths', '100', '40', 7),
(29, 'Science', '100', '40', 7),
(30, 'GK', '100', '40', 7),
(31, 'English', '100', '40', 8),
(32, 'Nepali', '100', '40', 8),
(33, 'Maths', '100', '40', 8),
(34, 'Science', '100', '40', 8),
(35, 'GK', '100', '40', 8);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(45) NOT NULL,
  `picture` text NOT NULL,
  `role_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `full_name`, `email`, `phone`, `username`, `password`, `picture`, `role_name`) VALUES
(1, 'Ankit Chamlagain', 'ankitchamlagain@gmail.com', 9862699637, 'ankeet77', '21232f297a57a5a743894a0e4a801fc3', 'C:\\Users\\Ankeet\\Documents\\NetBeansProjects\\ResultMgtSystem\\src\\Images\\&flix.jpg', 'Principal'),
(2, 'Aone Sen', 'aonesen18@gmail.com', 9867542103, 'aone', 'ee11cbb19052e40b07aac0ca060c23ee', 'C:\\Users\\Ankeet\\Documents\\NetBeansProjects\\ResultMgtSystem\\src\\Images\\aone.jpg', 'Administration');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(40) NOT NULL,
  `role_desc` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`role_id`, `role_name`, `role_desc`) VALUES
(1, 'Principal', 'All authorization.'),
(2, 'Administration', 'Limited Authorization.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `exams`
--
ALTER TABLE `exams`
  ADD PRIMARY KEY (`exam_id`);

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`g_id`);

--
-- Indexes for table `logins`
--
ALTER TABLE `logins`
  ADD PRIMARY KEY (`login_id`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `marks_obt`
--
ALTER TABLE `marks_obt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `grade_id` (`grade_id`);

--
-- Indexes for table `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`result_id`),
  ADD KEY `g_id` (`g_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `exam_id` (`exam_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `g_id` (`g_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `g_id` (`g_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `exams`
--
ALTER TABLE `exams`
  MODIFY `exam_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `grades`
--
ALTER TABLE `grades`
  MODIFY `g_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `logins`
--
ALTER TABLE `logins`
  MODIFY `login_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `marks_obt`
--
ALTER TABLE `marks_obt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `results`
--
ALTER TABLE `results`
  MODIFY `result_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logins`
--
ALTER TABLE `logins`
  ADD CONSTRAINT `logins_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`role_id`);

--
-- Constraints for table `marks_obt`
--
ALTER TABLE `marks_obt`
  ADD CONSTRAINT `marks_obt_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  ADD CONSTRAINT `marks_obt_ibfk_2` FOREIGN KEY (`grade_id`) REFERENCES `students` (`g_id`);

--
-- Constraints for table `results`
--
ALTER TABLE `results`
  ADD CONSTRAINT `results_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `grades` (`g_id`),
  ADD CONSTRAINT `results_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  ADD CONSTRAINT `results_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`),
  ADD CONSTRAINT `results_ibfk_4` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `grades` (`g_id`);

--
-- Constraints for table `subjects`
--
ALTER TABLE `subjects`
  ADD CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `grades` (`g_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
