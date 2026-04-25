/*
  # Vica Hydrate - Initial Schema

  1. New Tables
    - `products`
      - `id` (bigserial, primary key)
      - `name` (text) - product name e.g. "Vica Hydrate 500ml"
      - `size_ml` (int) - volume in millilitres
      - `price` (numeric) - price in INR
      - `description` (text)
      - `features` (text[]) - array of feature strings
      - `image_url` (text)
      - `in_stock` (boolean)
      - `created_at` (timestamptz)
    - `inquiries`
      - `id` (bigserial, primary key)
      - `name` (text) - sender name
      - `email` (text)
      - `phone` (text, nullable)
      - `message` (text)
      - `status` (text) - 'new', 'read', 'replied'
      - `created_at` (timestamptz)

  2. Security
    - Enable RLS on both tables
    - Products: public read, no write from anon
    - Inquiries: public insert only (to submit contact form), no read from anon
*/

-- Products table
CREATE TABLE IF NOT EXISTS products (
  id bigserial PRIMARY KEY,
  name text NOT NULL,
  size_ml integer NOT NULL,
  price numeric(10,2) NOT NULL,
  description text NOT NULL DEFAULT '',
  features text[] NOT NULL DEFAULT '{}',
  image_url text NOT NULL DEFAULT '',
  in_stock boolean NOT NULL DEFAULT true,
  created_at timestamptz NOT NULL DEFAULT now()
);

ALTER TABLE products ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Anyone can view products"
  ON products FOR SELECT
  TO anon, authenticated
  USING (true);

-- Inquiries table
CREATE TABLE IF NOT EXISTS inquiries (
  id bigserial PRIMARY KEY,
  name text NOT NULL,
  email text NOT NULL,
  phone text,
  message text NOT NULL,
  status text NOT NULL DEFAULT 'new',
  created_at timestamptz NOT NULL DEFAULT now()
);

ALTER TABLE inquiries ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Anyone can submit an inquiry"
  ON inquiries FOR INSERT
  TO anon, authenticated
  WITH CHECK (true);

CREATE POLICY "Authenticated users can view inquiries"
  ON inquiries FOR SELECT
  TO authenticated
  USING (true);

-- Seed product data
INSERT INTO products (name, size_ml, price, description, features, image_url, in_stock) VALUES
(
  'Vica Hydrate 500ml',
  500,
  25.00,
  'Perfect for on-the-go hydration. Our 500ml bottle delivers pH 8.5 alkaline water in a compact, tamper-proof, BPA-free bottle.',
  ARRAY['pH 8.5 Alkaline', 'Tamper-Proof Seal', 'BPA-Free', 'Recyclable PET', 'BIS Certified'],
  '/images/bottle.png',
  true
),
(
  'Vica Hydrate 1L',
  1000,
  45.00,
  'The ideal everyday companion. Our 1L bottle is designed for active lifestyles, offering sustained alkaline hydration throughout your day.',
  ARRAY['pH 8.5 Alkaline', 'Tamper-Proof Seal', 'BPA-Free', 'Recyclable PET', 'BIS Certified', 'Export-Ready'],
  '/images/bottle.png',
  true
),
(
  'Vica Hydrate 2L',
  2000,
  80.00,
  'Family-sized premium alkaline water. Our 2L bottle is perfect for home and office use, with our signature hexagonal water structure.',
  ARRAY['pH 8.5 Alkaline', 'Tamper-Proof Seal', 'BPA-Free', 'Recyclable PET', 'BIS Certified', 'Export-Ready', 'Family Size'],
  '/images/bottle.png',
  true
)
ON CONFLICT DO NOTHING;
