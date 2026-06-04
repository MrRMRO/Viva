# Viva
Liquor Shop E-Commerce Architecture
Technology Stack
Backend
•
•
•
•
•
•
Java EE (Enterprise Edition)
Hibernate (ORM for database operations)
Jersey (JAX-RS implementation for REST APIs)
MySQL/PostgreSQL (Database)
JavaMail API (Email verification)
BCrypt (Password hashing)
Frontend
• HTML5/CSS3/JavaScript
• Bootstrap/Tailwind CSS (Responsive design)
• jQuery/Vanilla JS (AJAX calls to REST APIs)
Application Layers
1. Presentation Layer (Frontend)
   ├── pages/
   │
   ├── index.html (Home page)
   │
   ├── login.html
   │
   ├── register.html
   │
   ├── verify-email.html
   │
   ├── products.html (Product listing)
   │
   ├── product-detail.html
   │
   ├── cart.html
   │
   ├── checkout.html
   │
   ├── order-confirmation.html
   │
   ├── profile.html
   │
   └── admin/
   │
   ├── dashboard.html
   │
   ├── products-manage.html
   │
   ├── add-product.html
   │
   └── orders-manage.html
   ├── css/
   ├── js/
   └── images/
2. REST API Layer (Jersey)
   com.liquorshop.api/
   ├── resources/
   │
   ├── AuthResource.java (Sign up, Sign in, Verification)
   │
   ├── ProductResource.java (CRUD, Search, Filter)
   │
   ├── CartResource.java (Add, Update, Remove items)
   │
   ├── OrderResource.java (Checkout, Order history)
   │
   ├── UserResource.java (Profile management)│
   ├── AdminResource.java (Admin operations)
   │
   └── FileUploadResource.java (Image uploads)
   ├── filters/
   │
   ├── AuthenticationFilter.java
   │
   ├── CORSFilter.java
   │
   └── AdminAuthorizationFilter.java
   └── config/
   └── JerseyConfig.java
   Sample REST Endpoints:
   Authentication:
   POST
   /api/auth/register
   POST
   /api/auth/login
   GET
   /api/auth/verify?token={token}
   POST
   /api/auth/forgot-password
   POST
   /api/auth/reset-password
   Products:
   GET
   /api/products (with pagination, sorting)
   GET
   /api/products/{id}
   GET
   /api/products/search?q={query}
   GET
   /api/products/filter?category={cat}&brand={brand}&minPrice={min}
   &maxPrice={max}
   POST
   /api/products (Admin only)
   PUT
   /api/products/{id} (Admin only)
   DELETE /api/products/{id} (Admin only)
   Cart:
   GET
   /api/cart
   POST
   /api/cart/items
   PUT
   /api/cart/items/{itemId}
   DELETE /api/cart/items/{itemId}
   POST
   /api/cart/merge (Merge session cart to user cart)
   Orders:
   POST
   /api/orders/checkout
   GET
   /api/orders
   GET
   /api/orders/{id}
   GET
   /api/orders/{id}/invoice
   User:
   GET
   PUT
   POST
   /api/users/profile
   /api/users/profile
   /api/users/profile/image
   Admin:
   GET
   /api/admin/dashboard/stats
   GET
   /api/admin/orders
   PUT
   /api/admin/orders/{id}/status
3. Service Layer
   com.liquorshop.service/
   ├── AuthService.java
   ├── UserService.java
   ├── ProductService.java
   ├── CartService.java
   ├── OrderService.java
   ├── EmailService.java
   ├── FileUploadService.java
   └── InvoiceService.javaResponsibilities:
   •
   •
   •
   •
   •
   Business logic implementation
   Transaction management
   Data validation
   Email sending (verification, order confirmation)
   Invoice generation (PDF)
4. Data Access Layer (Hibernate)
   com.liquorshop.dao/
   ├── UserDAO.java
   ├── ProductDAO.java
   ├── CategoryDAO.java
   ├── BrandDAO.java
   ├── CartDAO.java
   ├── OrderDAO.java
   ├── AddressDAO.java
   └── ReviewDAO.java
   Responsibilities:
   • Database CRUD operations
   • Complex queries using HQL/Criteria API
   • Transaction handling
5. Entity Layer (JPA/Hibernate)
   com.liquorshop.entity/
   ├── User.java
   ├── Address.java
   ├── Product.java
   ├── Category.java
   ├── Brand.java
   ├── ProductImage.java
   ├── Cart.java
   ├── CartItem.java
   ├── Order.java
   ├── OrderItem.java
   ├── Invoice.java
   └── Review.java
6. Utility Layer
   com.liquorshop.util/
   ├── PasswordUtil.java (BCrypt hashing)
   ├── TokenUtil.java (JWT/Random token generation)
   ├── EmailUtil.java (Email templates)
   ├── FileUtil.java (File upload validation)
   ├── ValidationUtil.java (Input validation)
   └── SessionUtil.java (Session management)Key Features Implementation
   Authentication Flow
1. User registers → Password hashed with BCrypt → Verification email sent
2. User clicks verification link → Token validated → Account activated
3. User logs in → Credentials verified → Session/JWT token generated
   Cart Management
   Session Cart (Guest Users):
   • Store cart in HTTP session
   • Identified by session ID
   • Merge with database cart upon login
   Database Cart (Logged-in Users):
   • Persistent cart stored in database
   • Survives across sessions
   • Auto-merge session cart on login
   Search Implementation
   Basic Search:
   • Search by product name, brand, category
   • Uses LIKE queries with Hibernate
   Advanced Search/Filter:
   • Multi-criteria filtering (category, brand, price range, alcohol %, volume)
   • Sorting options (price, name, rating, newest)
   • Pagination support
   File Upload
   •
   •
   •
   •
   •
   Product images stored in server directory
   Profile images stored in user-specific folders
   File validation (type, size)
   Image resizing/optimization
   Database stores file paths
   Checkout Process
1. Review cart items
2. Select/add shipping address
3. Choose payment method
4. Place order → Stock updated → Email sent
5. Generate invoice (PDF)
6. Display order confirmationAdmin Dashboard
   •
   •
   •
   •
   •
   View statistics (sales, orders, users)
   Manage products (CRUD operations)
   Manage orders (update status)
   Inventory management
   User management
   Security Considerations
1. Password Security: BCrypt hashing with salt
2. SQL Injection Prevention: Prepared statements via Hibernate
3. XSS Prevention: Input sanitization
4. CSRF Protection: Token-based validation
5. Session Security: HTTP-only cookies, session timeout
6. Age Verification: Check user age (18+) during registration
7. File Upload Security: Validate file types and sizes
8. Authorization: Role-based access control (RBAC)
   Deployment Structure
   liquor-shop.war
   ├── WEB-INF/
   │
   ├── web.xml
   │
   ├── classes/
   │
   │
   └── com/liquorshop/...
   │
   ├── lib/
   │
   │
   ├── hibernate-core.jar
   │
   │
   ├── jersey-server.jar
   │
   │
   ├── mysql-connector.jar
   │
   │
   └── ...
   │
   └── persistence.xml
   ├── uploads/
   │
   ├── products/
   │
   └── profiles/
   ├── static/
   │
   ├── css/
   │
   ├── js/
   │
   └── images/
   └── index.html
   Development Workflow
1. Setup Database: Execute SQL schema
2. Configure Hibernate: persistence.xml with database credentials
3. Create Entities: Map to database tables
4. Implement DAOs: Database operations
5. Build Services: Business logic6. Create REST APIs: Jersey resources
7. Develop Frontend: HTML/CSS/JS with AJAX calls
8. Test APIs: Postman/REST client
9. Integrate Frontend: Connect to backend APIs
   10.Deploy: Package as WAR, deploy to Tomcat/GlassFish
   Performance Optimization
   •
   •
   •
   •
   •
   •
   •
   Database indexing on frequently queried columns
   Connection pooling (HikariCP/C3P0)
   Caching (Hibernate second-level cache)
   Lazy loading for entities
   Pagination for large datasets
   Image compression and CDN usage
   Minification of CSS/JS files# Liquor-Shop-Backend
