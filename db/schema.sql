-- Vica Hydrate - MySQL Schema

-- Create database
CREATE DATABASE IF NOT EXISTS vica_hydrate;
USE vica_hydrate;

-- Products table
CREATE TABLE IF NOT EXISTS products (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  size_ml INT NOT NULL,
  price DECIMAL(10,2) NOT NULL,mysmy
  description LONGTEXT DEFAULT '',
  features LONGTEXT DEFAULT '',
  image_url VARCHAR(500) DEFAULT '',
  in_stock BOOLEAN DEFAULT true,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Inquiries table
CREATE TABLE IF NOT EXISTS inquiries (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(20),
  message LONGTEXT NOT NULL,
  status VARCHAR(50) DEFAULT 'new',
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Seed products
INSERT INTO products (name, size_ml, price, description, features, image_url, in_stock) VALUES
(
  'Vica Hydrate 500ml',
  500,
  25.00,
  'Perfect for on-the-go hydration. Our 500ml bottle delivers pH 8.5 alkaline water in a compact, tamper-proof, BPA-free bottle.',
  
  '/images/bottle.png',
  true
),
(
  'Vica Hydrate 1L',
  1000,
  45.00,
  'The ideal everyday companion. Our 1L bottle is designed for active lifestyles, offering sustained alkaline hydration throughout your day.',
  'pH 8.5 Alkaline|Tamper-Proof Seal|BPA-Free|Recyclable PET|BIS Certified|Export-Ready',
  '/images/bottle.png',
  true
),
(
  'Vica Hydrate 2L',
  2000,
  80.00,
  'Family-sized premium alkaline water. Our 2L bottle is perfect for home and office use, with our signature hexagonal water structure.',
  'pH 8.5 Alkaline|Tamper-Proof Seal|BPA-Free|Recyclable PET|BIS Certified|Export-Ready|Family Size',
  '/images/bottle.png',
  true
);

-- Create indexes
CREATE INDEX idx_products_in_stock ON products(in_stock);
CREATE INDEX idx_inquiries_status ON inquiries(status);
CREATE INDEX idx_inquiries_email ON inquiries(email);
