-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2022 at 06:27 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `makiniclinic`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `Appointment_id` int(25) NOT NULL,
  `Patient_id` varchar(255) NOT NULL,
  `PhoneNo` varchar(50) NOT NULL,
  `Doctor_id` varchar(25) NOT NULL,
  `Appointment_date` date NOT NULL,
  `Appointment_time` time(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `Doctor_No` int(25) NOT NULL,
  `Doctor_id` varchar(25) NOT NULL,
  `FName` varchar(25) NOT NULL,
  `LName` varchar(25) NOT NULL,
  `Sex` enum('Male','Female','','') NOT NULL,
  `PhoneNo` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `Availability` enum('Yes','No','','') NOT NULL DEFAULT 'Yes',
  `Profession` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`Doctor_No`, `Doctor_id`, `FName`, `LName`, `Sex`, `PhoneNo`, `password`, `Availability`, `Profession`) VALUES
(1, '315649', 'John', 'Moses', 'Male', '0789562389', 'jmoses', 'Yes', 'Physician'),
(2, '314642', 'James', 'Milner', 'Male', '0726231519', 'jmilner', 'Yes', 'Physician');

-- --------------------------------------------------------

--
-- Table structure for table `out_patients`
--

CREATE TABLE `out_patients` (
  `Patient_No` int(255) NOT NULL,
  `Patient_id` varchar(6) NOT NULL,
  `FName` varchar(255) DEFAULT NULL,
  `LName` varchar(255) NOT NULL,
  `PhoneNo` varchar(25) NOT NULL,
  `Sex` varchar(50) NOT NULL,
  `Illness` varchar(255) DEFAULT NULL,
  `Doctor_id` int(25) DEFAULT NULL,
  `Discharged` enum('Yes','No','','') NOT NULL DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `out_patients`
--

INSERT INTO `out_patients` (`Patient_No`, `Patient_id`, `FName`, `LName`, `PhoneNo`, `Sex`, `Illness`, `Doctor_id`, `Discharged`) VALUES
(1, '321649', 'Maria', 'Yvonne', '0142378951', 'Female', 'Malaria', 315649, 'Yes'),
(2, '714356', 'Lorna', 'Rhodes', '0145248321', 'Female', 'Malaria', 314642, 'Yes'),
(3, '901251', 'Dennis', 'Morgan', '0134512672', 'Male', 'Sore Throat', 314642, 'Yes'),
(4, '214512', 'Peter', 'Macharia', '0124563955', 'Male', 'Malaria', 314642, 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `Patient_No` int(25) NOT NULL,
  `Patient_id` varchar(6) NOT NULL,
  `FName` varchar(20) NOT NULL,
  `LName` varchar(20) NOT NULL,
  `Sex` varchar(11) NOT NULL,
  `PhoneNo` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`Patient_No`, `Patient_id`, `FName`, `LName`, `Sex`, `PhoneNo`, `password`) VALUES
(1, '315647', 'John', 'Kamau', 'Male', '0132569121', 'jkamau'),
(2, '321649', 'Maria', 'Yvonne', 'Female', '0142378951', 'myvonne'),
(3, '714356', 'Lorna', 'Rhodes', 'Female', '0145218321', 'lrhodes'),
(4, '901251', 'Dennis', 'Morgan', 'Male', '0134512672', 'dmorgan'),
(5, '214512', 'Peter', 'Macharia', 'Male', '0124563955', 'pmacharia'),
(6, '512364', 'Rebecca', 'Wamae', 'Female', '0217566325', 'rwamae'),
(7, '945236', 'Rose', 'Purity', 'Female', '0125469835', 'rpurity');

-- --------------------------------------------------------

--
-- Table structure for table `pharmacy`
--

CREATE TABLE `pharmacy` (
  `product_id` int(25) NOT NULL,
  `product_type` varchar(25) NOT NULL,
  `product_quantity` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pharmacy`
--

INSERT INTO `pharmacy` (`product_id`, `product_type`, `product_quantity`) VALUES
(1, 'Analgesics', 50),
(2, 'Antibiotics', 100),
(3, 'Vaccines', 60),
(4, 'Supplements', 45);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `Staff_id` int(25) NOT NULL,
  `FName` varchar(25) NOT NULL,
  `LName` varchar(25) NOT NULL,
  `Sex` enum('Male','Female','','') NOT NULL,
  `PhoneNo` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`Staff_id`, `FName`, `LName`, `Sex`, `PhoneNo`, `Password`) VALUES
(1, 'Hannah', 'Kelly', 'Female', '0722176197', 'hkelly');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`Appointment_id`),
  ADD UNIQUE KEY `No` (`PhoneNo`) USING BTREE;

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`Doctor_No`) USING BTREE;

--
-- Indexes for table `out_patients`
--
ALTER TABLE `out_patients`
  ADD PRIMARY KEY (`Patient_No`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`Patient_No`),
  ADD UNIQUE KEY `PhoneNo` (`PhoneNo`);

--
-- Indexes for table `pharmacy`
--
ALTER TABLE `pharmacy`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Staff_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `Appointment_id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `out_patients`
--
ALTER TABLE `out_patients`
  MODIFY `Patient_No` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `Patient_No` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pharmacy`
--
ALTER TABLE `pharmacy`
  MODIFY `product_id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `Staff_id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`PhoneNo`) REFERENCES `patients` (`PhoneNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
