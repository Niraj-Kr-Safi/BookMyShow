<!-- index.jsp -->
<!--  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookMyShow</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <h1>BookMyShow</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="movies">Movies</a></li>
                <li><a href="shows">Shows</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
        <section class="movie-list">
            <h2>Now Showing</h2>
            <div class="movies">
                <c:forEach items="${movies}" var="movie">
                    <div class="movie-card">
                        <h3>${movie.title}</h3>
                        <p>Genre: ${movie.genre}</p>
                        <p>Duration: ${movie.duration} mins</p>
                        <p>Language: ${movie.language}</p>
                        <a href="shows?movieId=${movie.movieId}" class="btn">Book Now</a>
                    </div>
                </c:forEach>
            </div>
        </section>
    </main>
    
    <script src="js/script.js"></script>
</body>
</html> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookMyShow</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        /* Navbar */
        .navbar {
            background: #1f2533;
            padding: 15px 50px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
            color: #f84464;
        }

        .nav-links a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
        }

        /* Hero Section */
        .hero {
            background: linear-gradient(rgba(0,0,0,0.7), rgba(0,0,0,0.7)),
                        url('/api/placeholder/1200/400');
            height: 400px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            text-align: center;
        }

        .hero h1 {
            font-size: 48px;
            margin-bottom: 20px;
        }

        /* Movie Grid */
        .movie-container {
            padding: 50px;
            background: #f5f5f5;
        }

        .section-title {
            font-size: 24px;
            margin-bottom: 30px;
        }

        .movie-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 30px;
        }

        .movie-card {
            background: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            transition: transform 0.3s;
        }

        .movie-card:hover {
            transform: translateY(-5px);
        }

        .movie-image {
            width: 100%;
            height: 300px;
            background: #ddd;
            position: relative;
        }

        .movie-details {
            padding: 20px;
        }

        .movie-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .movie-info {
            color: #666;
            margin-bottom: 15px;
            font-size: 14px;
        }

        .book-btn {
            background: #f84464;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }

        .book-btn:hover {
            background: #e03454;
        }

        /* Footer */
        .footer {
            background: #333545;
            color: white;
            padding: 50px;
            text-align: center;
        }

        .footer-content {
            max-width: 1200px;
            margin: 0 auto;
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 30px;
        }

        .footer-section h3 {
            margin-bottom: 20px;
            font-size: 18px;
        }

        .footer-section p {
            color: #aaa;
            line-height: 1.6;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .navbar {
                padding: 15px 20px;
            }

            .footer-content {
                grid-template-columns: repeat(2, 1fr);
            }

            .movie-container {
                padding: 20px;
            }
        }

        @media (max-width: 480px) {
            .footer-content {
                grid-template-columns: 1fr;
            }

            .hero h1 {
                font-size: 32px;
            }
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="logo">BookMyShow</div>
        <div class="nav-links">
            <a href="movies.jsp">Movies</a>
            <a href="#theaters">Theaters</a>
            <a href="#events">Events</a>
            <a href="login.jsp">Login</a>
        </div>
    </nav>

    <!-- Hero Section -->
    <div class="hero">
        <div class="hero-content">
            <h1>Book Your Entertainment</h1>
            <p>Watch the latest movies in theaters near you</p>
        </div>
    </div>

    <!-- Movies Section -->
    <div class="movie-container">
        <h2 class="section-title">Now Showing</h2>
        <div class="movie-grid">
            <!-- Movie 1 -->
            <div class="movie-card">
                <div class="movie-image">
                    <img src="/api/placeholder/250/300" alt="Movie 1">
                </div>
                <div class="movie-details">
                    <h3 class="movie-title">The Dark Knight</h3>
                    <p class="movie-info">
                        Action/Drama • 2h 32m<br>
                        Rating: 9.0/10
                    </p>
                    <button class="book-btn">Book Now</button>
                </div>
            </div>

            <!-- Movie 2 -->
            <div class="movie-card">
                <div class="movie-image">
                    <img src="/api/placeholder/250/300" alt="Movie 2">
                </div>
                <div class="movie-details">
                    <h3 class="movie-title">Inception</h3>
                    <p class="movie-info">
                        Sci-Fi/Action • 2h 28m<br>
                        Rating: 8.8/10
                    </p>
                    <button class="book-btn">Book Now</button>
                </div>
            </div>

            <!-- Movie 3 -->
            <div class="movie-card">
                <div class="movie-image">
                    <img src="/api/placeholder/250/300" alt="Movie 3">
                </div>
                <div class="movie-details">
                    <h3 class="movie-title">Interstellar</h3>
                    <p class="movie-info">
                        Sci-Fi/Adventure • 2h 49m<br>
                        Rating: 8.6/10
                    </p>
                    <button class="book-btn">Book Now</button>
                </div>
            </div>

            <!-- Movie 4 -->
            <div class="movie-card">
                <div class="movie-image">
                    <img src="/api/placeholder/250/300" alt="Movie 4">
                </div>
                <div class="movie-details">
                    <h3 class="movie-title">Avatar</h3>
                    <p class="movie-info">
                        Sci-Fi/Adventure • 2h 42m<br>
                        Rating: 7.8/10
                    </p>
                    <button class="book-btn">Book Now</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer">
        <div class="footer-content">
            <div class="footer-section">
                <h3>About Us</h3>
                <p>BookMyShow is India's largest entertainment ticketing platform.</p>
            </div>
            <div class="footer-section">
                <h3>Quick Links</h3>
                <p>Movies<br>Theaters<br>Events<br>Gift Cards</p>
            </div>
            <div class="footer-section">
                <h3>Help & Support</h3>
                <p>Contact Us<br>FAQ<br>Terms & Conditions<br>Privacy Policy</p>
            </div>
            <div class="footer-section">
                <h3>Connect With Us</h3>
                <p>Facebook<br>Twitter<br>Instagram<br>YouTube</p>
            </div>
        </div>
    </footer>

    <script>
        // Add smooth scrolling for navigation links
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();
                document.querySelector(this.getAttribute('href')).scrollIntoView({
                    behavior: 'smooth'
                });
            });
        });

        // Add click handlers for book buttons
        document.querySelectorAll('.book-btn').forEach(button => {
            button.addEventListener('click', function() {
                const movieTitle = this.parentElement.querySelector('.movie-title').textContent;
                alert(`Booking system opening for ${movieTitle}`);
                // In a real implementation, this would open the booking modal or redirect to booking page
            });
        });
    </script>
</body>
</html>