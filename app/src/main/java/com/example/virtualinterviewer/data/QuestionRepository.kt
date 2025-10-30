package com.example.virtualinterviewer.data

object QuestionRepository {

    // ---------------- Aptitude (30) ----------------
    val aptitudeQuestions: List<MCQQuestion> = listOf(
        MCQQuestion("If 3x + 2 = 11, what is x?", listOf("3","2","5","1"), "3"),
        MCQQuestion("What is 15% of 200?", listOf("25","30","20","35"), "30"),
        MCQQuestion("Simplify: 48 ÷ 8 × 3 =", listOf("6","12","18","9"), "18"),
        MCQQuestion("If A = 2, B = 3, then A² + B² = ?", listOf("5","12","13","10"), "13"),
        MCQQuestion("The average of 4, 8, 12 is:", listOf("6","8","10","12"), "8"),
        MCQQuestion("A train 100m long passes a pole in 10s. Speed?", listOf("10m/s","15m/s","12m/s","20m/s"), "10m/s"),
        MCQQuestion("What is √81?", listOf("9","8","7","10"), "9"),
        MCQQuestion("Simplify: (25 × 4) ÷ 10 =", listOf("10","5","20","15"), "10"),
        MCQQuestion("If 2x + 5 = 13, then x =", listOf("4","5","3","6"), "4"),
        MCQQuestion("What is the next prime after 7?", listOf("9","11","13","17"), "11"),
        MCQQuestion("What is 12²?", listOf("122","124","144","164"), "144"),
        MCQQuestion("Ratio of 2:4 is same as:", listOf("1:2","2:3","3:4","2:1"), "1:2"),
        MCQQuestion("Convert 0.75 to fraction:", listOf("1/2","3/4","2/3","4/5"), "3/4"),
        MCQQuestion("LCM of 4 and 6?", listOf("10","12","8","6"), "12"),
        MCQQuestion("Which is smallest prime number?", listOf("1","2","3","5"), "2"),
        MCQQuestion("If cost of 3 pens = ₹30, cost of 5 pens?", listOf("₹40","₹45","₹50","₹60"), "₹50"),
        MCQQuestion("Find area of 5x4 rectangle:", listOf("9","10","20","25"), "20"),
        MCQQuestion("Simplify: 9 × 9 =", listOf("81","72","99","90"), "81"),
        MCQQuestion("Add: 2/3 + 1/6 =", listOf("1/2","3/4","5/6","2/3"), "5/6"),
        MCQQuestion("If 40% of x = 50, x = ?", listOf("100","120","125","150"), "125"),
        MCQQuestion("Simplify: (8² + 6²)", listOf("64","100","120","36"), "100"),
        MCQQuestion("Simplify: 100 ÷ 4 × 2 =", listOf("25","50","75","100"), "50"),
        MCQQuestion("If 5x = 25, x =", listOf("10","5","2","15"), "5"),
        MCQQuestion("Convert 2.5 to fraction:", listOf("3/2","5/2","7/2","4/2"), "5/2"),
        MCQQuestion("If speed = distance/time, 100/5 =", listOf("20","25","15","30"), "20"),
        MCQQuestion("What is 5³?", listOf("15","25","75","125"), "125"),
        MCQQuestion("Simplify: 4 × (3 + 2)", listOf("20","15","25","12"), "20"),
        MCQQuestion("10% of 250 =", listOf("25","30","20","35"), "25"),
        MCQQuestion("If x = 2, 3x² + 2x =", listOf("14","16","12","18"), "16"),
        MCQQuestion("Find mean of 10, 20, 30", listOf("10","15","20","25"), "20")
    )

    // ---------------- Intro prompts (30) as LongQuestion (keywords) ----------------
    val introPrompts: List<LongQuestion> = listOf(
        LongQuestion("Tell me about yourself.", listOf("experience","projects","skills")),
        LongQuestion("What are your strengths?", listOf("strength","skill","experience")),
        LongQuestion("What are your weaknesses?", listOf("improve","learning","growth")),
        LongQuestion("Why do you want this role?", listOf("interest","role","contribute")),
        LongQuestion("Describe a difficult problem you solved.", listOf("problem","solution","impact")),
        LongQuestion("Tell me about a project you are proud of.", listOf("project","result","contribution")),
        LongQuestion("How do you keep your technical skills current?", listOf("learn","courses","practice")),
        LongQuestion("How do you handle tight deadlines?", listOf("prioritize","organize","plan")),
        LongQuestion("Describe your teamwork style.", listOf("team","collaborate","communication")),
        LongQuestion("What motivates you at work?", listOf("challenge","impact","learning")),
        LongQuestion("Describe a time you made a mistake and learned from it.", listOf("mistake","learn","improve")),
        LongQuestion("How do you manage conflicts on a team?", listOf("communication","resolve","compromise")),
        LongQuestion("What is your greatest achievement?", listOf("achievement","result","impact")),
        LongQuestion("How do you plan your professional development?", listOf("learning","goals","skills")),
        LongQuestion("Describe your ideal work environment.", listOf("collaborative","fast-paced","supportive")),
        LongQuestion("How do you prioritize tasks?", listOf("priority","important","urgent")),
        LongQuestion("What are your long-term career goals?", listOf("career","growth","aspire")),
        LongQuestion("How do you approach learning new technologies?", listOf("read","practice","projects")),
        LongQuestion("Describe your communication style.", listOf("clear","concise","listen")),
        LongQuestion("How do you measure success?", listOf("outcome","impact","metrics")),
        LongQuestion("Do you prefer working alone or in a team?", listOf("team","collaborate","independent")),
        LongQuestion("How do you deal with feedback?", listOf("listen","improve","apply")),
        LongQuestion("What tools do you use to stay organized?", listOf("todo","planner","calendar")),
        LongQuestion("Describe a leadership experience.", listOf("lead","coordinate","responsible")),
        LongQuestion("What makes you a good fit for this company?", listOf("culture","values","fit")),
        LongQuestion("How do you handle failure?", listOf("learn","adapt","improve")),
        LongQuestion("What is your approach to problem solving?", listOf("analyze","plan","execute")),
        LongQuestion("Tell me about a time you handled ambiguity.", listOf("uncertain","clarify","decide")),
        LongQuestion("What are you currently learning?", listOf("course","project","study")),
        LongQuestion("Do you have questions for us?", listOf("questions","role","team"))
    )

    // -------------- Android Developer (30 MCQ + 30 Long) --------------
    private val androidMCQs: List<MCQQuestion> = listOf(
        MCQQuestion("Which file declares app package and components in Android?", listOf("build.gradle","AndroidManifest.xml","settings.xml","proguard.txt"), "AndroidManifest.xml"),
        MCQQuestion("Which language is officially recommended for Android development?", listOf("Java","Kotlin","C#","Python"), "Kotlin"),
        MCQQuestion("Which component shows a UI screen in Android?", listOf("Service","Activity","BroadcastReceiver","ContentProvider"), "Activity"),
        MCQQuestion("What is RecyclerView used for?", listOf("Networking","Displaying lists","Storage","Security"), "Displaying lists"),
        MCQQuestion("Where do you declare app dependencies?", listOf("AndroidManifest.xml","build.gradle","gradle.properties","proguard.cfg"), "build.gradle"),
        MCQQuestion("Which class helps to save UI-related data across configuration changes?", listOf("ViewModel","Repository","Adapter","Context"), "ViewModel"),
        MCQQuestion("What is an Intent used for?", listOf("Database","Component communication","Styling","Testing"), "Component communication"),
        MCQQuestion("Which layout is recommended for complex responsive UI?", listOf("LinearLayout","RelativeLayout","ConstraintLayout","FrameLayout"), "ConstraintLayout"),
        MCQQuestion("What is LiveData used for?", listOf("HTTP calls","Lifecycle-aware data holder","UI themes","Build scripts"), "Lifecycle-aware data holder"),
        MCQQuestion("What file contains strings and colors?", listOf("AndroidManifest.xml","res/values/strings.xml","MainActivity.kt","build.gradle"), "res/values/strings.xml"),
        MCQQuestion("Which process runs background tasks in Android?", listOf("Activity","Service","BroadcastReceiver","Fragment"), "Service"),
        MCQQuestion("What is ADB used for?", listOf("Design","Debugging","Packaging","Localization"), "Debugging"),
        MCQQuestion("What is Jetpack Compose?", listOf("Database","UI toolkit","Networking library","Testing framework"), "UI toolkit"),
        MCQQuestion("Which permission is needed to access network?", listOf("ACCESS_NETWORK","INTERNET","NETWORK_STATE","ACCESS_WIFI"), "INTERNET"),
        MCQQuestion("What is an APK?", listOf("Source code","App package","Design file","Database"), "App package"),
        MCQQuestion("Which mechanism stores key-value pairs?", listOf("SharedPreferences","SQLite","Room","Files"), "SharedPreferences"),
        MCQQuestion("What is Room in Android?", listOf("UI library","ORM for SQLite","Testing tool","Animation lib"), "ORM for SQLite"),
        MCQQuestion("Which thread should update UI components?", listOf("Background thread","Worker thread","Main/UI thread","Any thread"), "Main/UI thread"),
        MCQQuestion("What is ProGuard used for?", listOf("Minification & obfuscation","Testing","Layout","Networking"), "Minification & obfuscation"),
        MCQQuestion("What is ANR in Android?", listOf("App Not Responding","Android Network Request","App New Resource","Auto Null Reference"), "App Not Responding"),
        MCQQuestion("Which lifecycle method is called when Activity created?", listOf("onStart","onCreate","onResume","onPause"), "onCreate"),
        MCQQuestion("What is data binding?", listOf("Network call","Binding UI to data","Encryption","Animation"), "Binding UI to data"),
        MCQQuestion("Which tool analyzes APK size?", listOf("Android Profiler","APK Analyzer","Logcat","ADB"), "APK Analyzer"),
        MCQQuestion("What is Fragment in Android?", listOf("Independent app","Reusable UI component inside Activity","Service","Database"), "Reusable UI component inside Activity"),
        MCQQuestion("How to store structured data persistently?", listOf("SharedPreferences","Room/SQLite","Temporary files","Logs"), "Room/SQLite"),
        MCQQuestion("Which library helps with image loading?", listOf("Retrofit","Glide","Room","Coroutines"), "Glide"),
        MCQQuestion("What is Retrofit for?", listOf("Database","Networking/HTTP client","UI rendering","Testing"), "Networking/HTTP client"),
        MCQQuestion("What is Kotlin Coroutines for?", listOf("Synchronous tasks","Asynchronous concurrency","UI themes","Storage"), "Asynchronous concurrency"),
        MCQQuestion("Which component listens to system-wide events?", listOf("Service","Activity","BroadcastReceiver","Fragment"), "BroadcastReceiver"),
        MCQQuestion("How are resources accessed programmatically?", listOf("R.id","R.string","R.layout","R.drawable"), "R.string")
    )

    private val androidLong: List<LongQuestion> = listOf(
        LongQuestion("Explain the Android activity lifecycle and how to manage state.", listOf("onCreate","onStart","onResume","onPause","onStop","onDestroy")),
        LongQuestion("Describe the differences between Fragment and Activity.", listOf("modular","lifecycle","UI","reuse")),
        LongQuestion("Explain memory leaks in Android and how to prevent them.", listOf("leak","context","lifecycle","reference")),
        LongQuestion("Describe how to implement a RecyclerView with ViewHolder pattern.", listOf("ViewHolder","adapter","onCreateViewHolder","onBindViewHolder")),
        LongQuestion("Explain how to use ViewModel and LiveData for UI updates.", listOf("ViewModel","LiveData","lifecycle","observe")),
        LongQuestion("Explain how to do background work respecting battery using WorkManager.", listOf("WorkManager","background","constraints","schedule")),
        LongQuestion("Describe the purpose of AndroidManifest and its common entries.", listOf("permissions","activities","services","intent-filter")),
        LongQuestion("Explain how to use Room for local persistence.", listOf("entities","dao","database","query")),
        LongQuestion("Describe best practices for networking (Retrofit + Coroutines).", listOf("Retrofit","Coroutines","suspend","error handling")),
        LongQuestion("Explain Jetpack Compose basics and advantages.", listOf("composable","state","compose","ui toolkit")),
        LongQuestion("Describe data binding and view binding differences.", listOf("binding","safety","performance","layout")),
        LongQuestion("Explain how to secure API keys in an Android app.", listOf("keystore","env","obfuscation","server")),
        LongQuestion("Describe how to handle configuration changes gracefully.", listOf("retain","ViewModel","onSaveInstanceState","recreate")),
        LongQuestion("Explain app performance profiling tools and approaches.", listOf("profiler","cpu","memory","network")),
        LongQuestion("Discuss how to implement localization in Android.", listOf("strings.xml","locale","resources","translations")),
        LongQuestion("Explain deep linking and app links.", listOf("intent","uri","manifest","navigation")),
        LongQuestion("Describe Android security best practices.", listOf("permissions","encryption","secure storage","network")),
        LongQuestion("Explain how to write unit and instrumentation tests.", listOf("JUnit","Espresso","mock","testing")),
        LongQuestion("Discuss modularization and feature modules.", listOf("module","gradle","dependency","isolation")),
        LongQuestion("Explain how to implement push notifications.", listOf("FCM","notification","token","payload")),
        LongQuestion("Describe how to implement caching strategies for networking.", listOf("cache","okhttp","ttl","storage")),
        LongQuestion("Explain accessibility considerations in Android apps.", listOf("contentDescription","focus","colors","screen reader")),
        LongQuestion("Describe the role of Gradle in Android builds.", listOf("build","dependencies","flavors","tasks")),
        LongQuestion("Explain incremental annotation processing and kapt.", listOf("kapt","annotation","processor","generate")),
        LongQuestion("Describe how to reduce APK size and optimize assets.", listOf("shrink","proguard","split","resources")),
        LongQuestion("Explain how to implement authentication (OAuth) in Android.", listOf("OAuth","token","refresh","secure")),
        LongQuestion("Discuss strategies for offline-first apps.", listOf("cache","sync","local db","fallback")),
        LongQuestion("Explain integration with native libraries using NDK.", listOf("ndk","jni","native","c++")),
        LongQuestion("Describe how to manage dependencies with Gradle.", listOf("dependency","version","maven","artifact")),
        LongQuestion("Explain how to do analytics and crash reporting integration.", listOf("analytics","crashlytics","report","events")),
        LongQuestion("Discuss CI/CD and play store release best practices.", listOf("ci","cd","release","signing"))
    )

    // -------------- Web Developer --------------
    private val webMCQs: List<MCQQuestion> = listOf(
        MCQQuestion("Which protocol is used to fetch web pages?", listOf("FTP","SMTP","HTTP","SSH"), "HTTP"),
        MCQQuestion("Which language is used to style web pages?", listOf("HTML","CSS","JavaScript","SQL"), "CSS"),
        MCQQuestion("Which is a JavaScript framework?", listOf("Django","React","Laravel","Rails"), "React"),
        MCQQuestion("What does REST stand for?", listOf("Representational State Transfer","Remote State Transfer","Representational Server Transfer","Remote Server Transfer"), "Representational State Transfer"),
        MCQQuestion("What is CORS used for?", listOf("Styling","Cross origin requests","Routing","Templating"), "Cross origin requests"),
        MCQQuestion("Which header indicates content type?", listOf("Accept","Content-Type","Host","Authorization"), "Content-Type"),
        MCQQuestion("What is a SPA?", listOf("Single Page App","Server Process API","Single Proxy App","Service Page App"), "Single Page App"),
        MCQQuestion("Which CSS preprocessor is popular?", listOf("SASS","LESSON","SCSSX","CSST"), "SASS"),
        MCQQuestion("Which HTTP method creates resources?", listOf("GET","PUT","POST","DELETE"), "POST"),
        MCQQuestion("What is WebSocket used for?", listOf("File transfer","Real-time communication","Styling","Database"), "Real-time communication"),
        MCQQuestion("Which tool bundles JS modules?", listOf("Webpack","MySQL","Nginx","Redis"), "Webpack"),
        MCQQuestion("What is semantic HTML?", listOf("Meaningful tags","CSS classes","JS functions","Database schema"), "Meaningful tags"),
        MCQQuestion("Which meta tag affects mobile viewport?", listOf("charset","viewport","author","description"), "viewport"),
        MCQQuestion("What does CDN stand for?", listOf("Content Delivery Network","Central Data Network","Content Data Node","Central Delivery Node"), "Content Delivery Network"),
        MCQQuestion("Which status code means Not Found?", listOf("200","301","403","404"), "404"),
        MCQQuestion("Which is a NoSQL DB often used with Node.js?", listOf("MySQL","Postgres","MongoDB","Oracle"), "MongoDB"),
        MCQQuestion("What is Progressive Web App (PWA)?", listOf("Native app","Web app with PWA features","Server only app","Database app"), "Web app with PWA features"),
        MCQQuestion("Which directive is used in Angular templates?", listOf("v-if","*ngIf","ng-show","x-if"), "*ngIf"),
        MCQQuestion("Which property centers items in flexbox?", listOf("align-items","justify-content","flex-direction","flex-wrap"), "justify-content"),
        MCQQuestion("Which tool is for testing JS code?", listOf("JUnit","Mocha/Jest","Selenium","Postman"), "Mocha/Jest"),
        MCQQuestion("Which header secures cookies to HTTPS?", listOf("HttpOnly","Secure","SameSite","Path"), "Secure"),
        MCQQuestion("What is SSR (Server Side Rendering)?", listOf("Rendering on server","Security method","Storage","Routing"), "Rendering on server"),
        MCQQuestion("Which tag loads external JS?", listOf("<link>","<script>","<style>","<meta>"), "<script>"),
        MCQQuestion("What is localStorage used for?", listOf("temporary UI","persistent key-value storage in browser","server storage","database"), "persistent key-value storage in browser"),
        MCQQuestion("Which HTTP code indicates server error?", listOf("2xx","3xx","4xx","5xx"), "5xx"),
        MCQQuestion("What does RESTful API use mainly?", listOf("XML","HTTP","FTP","SMTP"), "HTTP"),
        MCQQuestion("Which CSS layout replaces floats for grid-like layout?", listOf("float","table","CSS Grid","inline"), "CSS Grid"),
        MCQQuestion("What is HTTPS?", listOf("HTTP secure (TLS)","HyperText Transfer Plain","Host Transfer","High Transfer"), "HTTP secure (TLS)"),
        MCQQuestion("Which tool lints JS code?", listOf("ESLint","Prettier","Babel","Webpack"), "ESLint"),
        MCQQuestion("Which is used for image optimization on web?", listOf("SVG only","Image compression & responsive images","No optimization","Database compression"), "Image compression & responsive images")
    )

    private val webLong: List<LongQuestion> = listOf(
        LongQuestion("Explain how HTTP request-response works.", listOf("request","response","headers","status","body")),
        LongQuestion("Describe the difference between REST and GraphQL.", listOf("REST","GraphQL","endpoints","query","flexible")),
        LongQuestion("Explain how to secure a web application.", listOf("HTTPS","input validation","csrf","xss","sanitize")),
        LongQuestion("Describe how browser rendering works (critical rendering path).", listOf("DOM","CSSOM","render tree","layout","painting")),
        LongQuestion("Explain client-side vs server-side rendering.", listOf("client","server","render","seo","performance")),
        LongQuestion("Discuss responsive design best practices.", listOf("media queries","flexbox","grid","viewport")),
        LongQuestion("Explain CORS and how to handle it.", listOf("origin","headers","Access-Control-Allow-Origin","preflight")),
        LongQuestion("Describe caching strategies for web apps.", listOf("cache-control","ETag","service worker","cdn")),
        LongQuestion("Explain how to build a Progressive Web App.", listOf("service worker","manifest","offline","installable")),
        LongQuestion("Discuss RESTful API design best practices.", listOf("resource","verbs","stateless","status codes")),
        LongQuestion("Explain WebSocket vs HTTP.", listOf("persistent","full-duplex","real-time","socket")),
        LongQuestion("Describe common web performance optimizations.", listOf("minify","compress","cache","critical")),
        LongQuestion("Explain authentication vs authorization.", listOf("authn","authz","token","roles")),
        LongQuestion("Describe database indexing and when it helps.", listOf("index","query","performance","columns")),
        LongQuestion("Explain how frontend build tools work (webpack etc.).", listOf("bundle","loader","plugin","entry")),
        LongQuestion("Describe accessibility best practices.", listOf("aria","semantic","contrast","keyboard")),
        LongQuestion("Explain how to implement SEO friendly SPA.", listOf("SSR","prerender","meta tags","sitemap")),
        LongQuestion("Discuss containerization in web deployments.", listOf("docker","image","container","orchestration")),
        LongQuestion("Explain how to do A/B testing.", listOf("experiment","variant","metric","statistical")),
        LongQuestion("Discuss how to scale a web app horizontally.", listOf("load balancer","stateless","replicas","autoscale")),
        LongQuestion("Explain how to protect against SQL injection.", listOf("prepared statements","sanitize","orm","escape")),
        LongQuestion("Describe how CDNs improve performance.", listOf("edge","cache","latency","distribution")),
        LongQuestion("Explain what TLS/SSL does.", listOf("encryption","certificate","handshake","secure")),
        LongQuestion("Discuss microservices architecture pros and cons.", listOf("scalability","complexity","deployment","team")),
        LongQuestion("Explain role of reverse proxy (e.g., Nginx).", listOf("proxy","cache","ssl","load balancing")),
        LongQuestion("Describe how websockets maintain connections.", listOf("handshake","frame","ping","keepalive")),
        LongQuestion("Explain how to do secure file uploads.", listOf("validation","storage","virus scan","acl")),
        LongQuestion("Describe server-side caching strategies.", listOf("redis","memcached","ttl","invalidate")),
        LongQuestion("Explain how to perform graceful degradation.", listOf("fallback","feature-detection","polyfill","user experience")),
        LongQuestion("Discuss observability: logging, metrics, tracing.", listOf("logs","metrics","tracing","alerts"))
    )

    // -------------- Data Analyst --------------
    private val dataMCQs: List<MCQQuestion> = listOf(
        MCQQuestion("Which SQL clause filters rows?", listOf("SELECT","WHERE","FROM","GROUP BY"), "WHERE"),
        MCQQuestion("What does ETL stand for?", listOf("Extract Transform Load","Extract Transfer Load","Evaluate Transform Load","Extract Transmit Load"), "Extract Transform Load"),
        MCQQuestion("Which plot is used for distribution?", listOf("bar chart","histogram","pie chart","line chart"), "histogram"),
        MCQQuestion("Which data type is suitable for categorical variables?", listOf("numeric","string","date","boolean"), "string"),
        MCQQuestion("Which library is used for dataframes in Python?", listOf("numpy","pandas","matplotlib","sklearn"), "pandas"),
        MCQQuestion("Which test compares means of two groups?", listOf("ANOVA","t-test","chi-square","regression"), "t-test"),
        MCQQuestion("What is overfitting?", listOf("underperformance","model too simple","model fits noise","feature scaling"), "model fits noise"),
        MCQQuestion("What is correlation coefficient range?", listOf("-2 to 2","-1 to 1","0 to 1","-100 to 100"), "-1 to 1"),
        MCQQuestion("Which is a measure of central tendency?", listOf("variance","mean","std dev","range"), "mean"),
        MCQQuestion("Which is a supervised learning algorithm?", listOf("k-means","decision tree","PCA","DBSCAN"), "decision tree"),
        MCQQuestion("Which metric for classification? (binary)", listOf("MSE","Accuracy","RMSE","SSE"), "Accuracy"),
        MCQQuestion("What is a pivot table used for?", listOf("modeling","summarizing data","visualization","clustering"), "summarizing data"),
        MCQQuestion("Which is used for time series forecasting?", listOf("ARIMA","KNN","SVM","KMeans"), "ARIMA"),
        MCQQuestion("Which plotting lib is Python standard?", listOf("ggplot","seaborn","matplotlib","d3.js"), "matplotlib"),
        MCQQuestion("What is data wrangling?", listOf("data cleaning","data storage","data visualization","data encryption"), "data cleaning"),
        MCQQuestion("What is bias in data?", listOf("data skew","accuracy","precision","recall"), "data skew"),
        MCQQuestion("Which is used to join tables in SQL?", listOf("UNION","JOIN","MERGE","APPEND"), "JOIN"),
        MCQQuestion("Which is a dimension reduction technique?", listOf("PCA","Regression","Decision Tree","KMeans"), "PCA"),
        MCQQuestion("What is a confusion matrix used for?", listOf("regression","classification evaluation","clustering","dimensionality"), "classification evaluation"),
        MCQQuestion("Which technique prevents overfitting?", listOf("regularization","increasing features","reducing data","no normalization"), "regularization"),
        MCQQuestion("Which distribution is symmetric and bell-shaped?", listOf("Uniform","Normal","Exponential","Poisson"), "Normal"),
        MCQQuestion("What is feature engineering?", listOf("model building","creating features from raw data","deploying model","testing model"), "creating features from raw data"),
        MCQQuestion("Which metric used for regression accuracy?", listOf("AUC","Precision","RMSE","Recall"), "RMSE"),
        MCQQuestion("Which SQL aggregates values across rows?", listOf("GROUP BY","ORDER BY","LIMIT","WHERE"), "GROUP BY"),
        MCQQuestion("What is heteroscedasticity?", listOf("constant variance","non-constant variance","normality","multicollinearity"), "non-constant variance"),
        MCQQuestion("Which visualization best shows relationship between two numeric variables?", listOf("bar","scatter","histogram","pie"), "scatter"),
        MCQQuestion("What is a p-value used for?", listOf("measure effect size","significance testing","normalization","clustering"), "significance testing"),
        MCQQuestion("Which sampling reduces bias?", listOf("convenience","random","judgmental","quota"), "random"),
        MCQQuestion("What does SQL stand for?", listOf("Structured Query Language","Simple Query Language","Sequential Query Language","Standard Query Language"), "Structured Query Language"),
        MCQQuestion("Which is a categorical encoding technique?", listOf("one-hot","scaling","normalization","pca"), "one-hot")
    )

    private val dataLong: List<LongQuestion> = listOf(
        LongQuestion("Explain the differences between supervised and unsupervised learning.", listOf("supervised","unsupervised","labels","clusters")),
        LongQuestion("Describe the steps in an ETL pipeline.", listOf("extract","transform","load","pipeline")),
        LongQuestion("Explain how to handle missing data.", listOf("impute","drop","mean","median")),
        LongQuestion("Describe how to detect outliers.", listOf("z-score","iqr","visualize","boxplot")),
        LongQuestion("Explain normalization vs standardization.", listOf("scale","normalize","z-score","min-max")),
        LongQuestion("Discuss feature engineering best practices.", listOf("create","transform","interaction","encode")),
        LongQuestion("Explain how to evaluate classification models.", listOf("accuracy","precision","recall","f1","roc")),
        LongQuestion("Describe how to build a dashboard for stakeholders.", listOf("visualization","insight","tool","stories")),
        LongQuestion("Explain time series decomposition.", listOf("trend","seasonality","residual","decompose")),
        LongQuestion("Discuss A/B testing methodology.", listOf("experiment","variant","p-value","metric")),
        LongQuestion("Describe how to scale data processing for big data.", listOf("spark","distributed","parallel","cluster")),
        LongQuestion("Explain cross-validation and why it is used.", listOf("cv","folds","validation","generalize")),
        LongQuestion("Describe how to deploy a model to production.", listOf("api","serving","monitor","version")),
        LongQuestion("Explain the bias-variance tradeoff.", listOf("bias","variance","overfitting","underfitting")),
        LongQuestion("Discuss techniques for feature selection.", listOf("filter","wrapper","embedded","importance")),
        LongQuestion("Explain how to clean text data for NLP tasks.", listOf("tokenize","stopword","stemming","lemmatize")),
        LongQuestion("Describe common pitfalls in data collection.", listOf("bias","missing","quality","sampling")),
        LongQuestion("Explain ensemble methods like random forest.", listOf("bagging","trees","ensemble","voting")),
        LongQuestion("Describe how to evaluate regression models.", listOf("rmse","mae","r2","mse")),
        LongQuestion("Discuss ethical issues in data analysis.", listOf("privacy","bias","consent","fairness")),
        LongQuestion("Explain dimensionality reduction techniques.", listOf("pca","lda","compression","variance")),
        LongQuestion("Describe the purpose of a data warehouse.", listOf("aggregated","historical","analytics","etl")),
        LongQuestion("Explain clustering algorithms and use cases.", listOf("kmeans","hierarchical","density","segments")),
        LongQuestion("Discuss how to create reproducible analysis.", listOf("versioning","notebooks","pipelines","documentation")),
        LongQuestion("Explain how to handle imbalanced datasets.", listOf("resample","weights","smote","class")),
        LongQuestion("Describe key steps in exploratory data analysis (EDA).", listOf("visualize","summary","detect","clean")),
        LongQuestion("Explain how SQL joins work with examples.", listOf("inner","left","right","full")),
        LongQuestion("Discuss model monitoring in production.", listOf("drift","metrics","alerts","retrain")),
        LongQuestion("Explain how to compress and store large datasets efficiently.", listOf("parquet","compression","partition","columnar")),
        LongQuestion("Describe the role of metadata in data systems.", listOf("schema","catalog","data dictionary","discover"))
    )

    // -------------- AI Engineer --------------
    private val aiMCQs: List<MCQQuestion> = listOf(
        MCQQuestion("Which activation function is used widely in deep learning?", listOf("Sigmoid","ReLU","Step","Linear"), "ReLU"),
        MCQQuestion("What is overfitting in ML?", listOf("good generalization","poor generalization due to memorization","fast training","undertraining"), "poor generalization due to memorization"),
        MCQQuestion("Which optimizer uses adaptive learning rates?", listOf("SGD","Adam","Momentum","RMSprop"), "Adam"),
        MCQQuestion("What is a confusion matrix used for?", listOf("regression","classification evaluation","clustering","scaling"), "classification evaluation"),
        MCQQuestion("Which metric is used for binary classification?", listOf("MSE","Accuracy","RMSE","SSE"), "Accuracy"),
        MCQQuestion("Which is a loss function for classification?", listOf("MSE","Cross-Entropy","MAE","Hinge"), "Cross-Entropy"),
        MCQQuestion("What is gradient descent used for?", listOf("optimization","data cleaning","visualization","feature selection"), "optimization"),
        MCQQuestion("What is transfer learning?", listOf("training from scratch","reusing pre-trained models","data augmentation","hyperparameter tuning"), "reusing pre-trained models"),
        MCQQuestion("What is batch normalization for?", listOf("regularization","stabilize activations","reduce parameters","increase learning rate"), "stabilize activations"),
        MCQQuestion("Which library is for deep learning in Python?", listOf("NumPy","Pandas","TensorFlow","SQLite"), "TensorFlow"),
        MCQQuestion("What is a learning rate?", listOf("data size","step size for optimizer","memory","batch size"), "step size for optimizer"),
        MCQQuestion("What does 'epoch' mean?", listOf("one forward pass","whole dataset passed once","one batch","validation pass"), "whole dataset passed once"),
        MCQQuestion("Which technique reduces overfitting?", listOf("increase model size","dropout","remove data","increase learning rate"), "dropout"),
        MCQQuestion("What is reinforcement learning about?", listOf("labels","agent and reward","statistical tests","data cleaning"), "agent and reward"),
        MCQQuestion("Which is unsupervised learning?", listOf("classification","clustering","regression","prediction"), "clustering"),
        MCQQuestion("What is backpropagation used for?", listOf("forward pass","compute gradients","data preprocessing","model saving"), "compute gradients"),
        MCQQuestion("What is embedding used for?", listOf("images only","convert categorical to vector","training speed","testing"), "convert categorical to vector"),
        MCQQuestion("Which optimizer uses momentum?", listOf("Adam","Momentum SGD","Adagrad","RMSprop"), "Momentum SGD"),
        MCQQuestion("What is a CNN primarily used for?", listOf("time series","images","tabular","text only"), "images"),
        MCQQuestion("Which evaluation metric suits imbalanced classes?", listOf("Accuracy","F1-score","MSE","RMSE"), "F1-score"),
        MCQQuestion("What is dropout?", listOf("layer normalization","randomly drop neurons during training","data augmentation","loss function"), "randomly drop neurons during training"),
        MCQQuestion("Which is a generative model?", listOf("SVM","GAN","KNN","Decision Tree"), "GAN"),
        MCQQuestion("What is the vanishing gradient problem?", listOf("gradients explode","gradients become too small to train","fast convergence","data leakage"), "gradients become too small to train"),
        MCQQuestion("What is tokenization in NLP?", listOf("training","splitting text into tokens","evaluation","visualization"), "splitting text into tokens"),
        MCQQuestion("Which is used for sequence modeling?", listOf("CNN","RNN","KMeans","PCA"), "RNN"),
        MCQQuestion("What does 'regularization' do?", listOf("increase variance","prevent overfitting","increase training time greatly","reduce data size"), "prevent overfitting"),
        MCQQuestion("What is precision in classification?", listOf("TP/(TP+FP)","TP/(TP+FN)","TN/(TN+FP)","TN/(TN+FN)"), "TP/(TP+FP)"),
        MCQQuestion("Which loss for regression?", listOf("Cross-Entropy","MSE","Categorical Loss","Hinge"), "MSE"),
        MCQQuestion("What is a learning curve?", listOf("training loss vs epochs","data size","parameters","initialization"), "training loss vs epochs"),
        MCQQuestion("What is model inference?", listOf("training","making predictions","data cleaning","tuning"), "making predictions")
    )

    private val aiLong: List<LongQuestion> = listOf(
        LongQuestion("Explain the training pipeline for a supervised learning model.", listOf("data","training","validation","test")),
        LongQuestion("Describe transfer learning and when to use it.", listOf("pretrained","fine-tune","feature extraction","domain")),
        LongQuestion("Explain CNN architecture components.", listOf("convolution","pooling","filter","feature map")),
        LongQuestion("Discuss methods to handle imbalanced datasets.", listOf("resample","class weight","smote","oversample")),
        LongQuestion("Explain evaluation metrics for regression and classification.", listOf("mse","rmse","accuracy","precision","recall")),
        LongQuestion("Describe hyperparameter tuning strategies.", listOf("grid","random","bayesian","cross-validation")),
        LongQuestion("Explain how to deploy a model to production.", listOf("serving","monitor","api","version")),
        LongQuestion("Discuss model interpretability techniques.", listOf("shap","lime","feature importance","explain")),
        LongQuestion("Explain gradient descent variants.", listOf("sgd","batch","mini-batch","optimizer")),
        LongQuestion("Describe sequence-to-sequence models and use cases.", listOf("encoder","decoder","attention","seq2seq")),
        LongQuestion("Explain attention mechanism in transformers.", listOf("attention","query","key","value")),
        LongQuestion("Discuss how to prevent data leakage.", listOf("split","validation","pipeline","feature engineering")),
        LongQuestion("Explain reinforcement learning basics and reward shaping.", listOf("agent","reward","environment","policy")),
        LongQuestion("Describe GANs and typical applications.", listOf("generator","discriminator","adversarial","synthesis")),
        LongQuestion("Explain embedding techniques for NLP.", listOf("word2vec","glove","bert","represent")),
        LongQuestion("Discuss model monitoring and drift detection.", listOf("drift","retrain","monitor","metrics")),
        LongQuestion("Explain automated ML (AutoML) concepts.", listOf("search","pipeline","hyperparameter","automate")),
        LongQuestion("Describe privacy-preserving ML techniques.", listOf("differential privacy","federated","encryption","mask")),
        LongQuestion("Explain sequence modeling for time series forecasting.", listOf("RNN","LSTM","ARIMA","seasonality")),
        LongQuestion("Describe pruning and quantization for model compression.", listOf("prune","quantize","size","latency")),
        LongQuestion("Explain transfer learning for computer vision tasks.", listOf("pretrained","fine-tune","feature extractor","dataset")),
        LongQuestion("Discuss data augmentation strategies for images.", listOf("rotate","flip","crop","color")),
        LongQuestion("Explain the role of validation set in ML.", listOf("tune","generalize","early stopping","hyperparameter")),
        LongQuestion("Describe how batch normalization stabilizes training.", listOf("normalize","mean","variance","scale")),
        LongQuestion("Explain how to use embeddings for recommendation systems.", listOf("user","item","vector","similarity")),
        LongQuestion("Discuss pitfalls in model evaluation (leakage, wrong metric).", listOf("leakage","metric","bias","overfit")),
        LongQuestion("Explain continual learning and catastrophic forgetting.", listOf("continual","forgetting","retrain","buffer")),
        LongQuestion("Describe how attention and transformers replaced RNNs for many tasks.", listOf("transformer","attention","parallel","sequence")),
        LongQuestion("Explain the lifecycle of an ML project from data to deployment.", listOf("collect","train","deploy","monitor"))
    )

    // -------------- Cybersecurity Specialist --------------
    private val secMCQs: List<MCQQuestion> = listOf(
        MCQQuestion("What does CIA triad stand for?", listOf("Confidentiality, Integrity, Availability","Control, Integrity, Access","Confidentiality, Information, Access","Control, Information, Audit"), "Confidentiality, Integrity, Availability"),
        MCQQuestion("Which is an example of two-factor authentication?", listOf("Password only","Token and password","Username only","SSO only"), "Token and password"),
        MCQQuestion("What is SQL injection?", listOf("A DB backup","Injection of malicious SQL","Firewall rule","Encryption method"), "Injection of malicious SQL"),
        MCQQuestion("Which protocol secures HTTP?", listOf("FTP","SMTP","HTTPS","TELNET"), "HTTPS"),
        MCQQuestion("What is XSS?", listOf("Cross-site scripting","Cross-site styling","Cross-site share","Cross-site security"), "Cross-site scripting"),
        MCQQuestion("What is CSRF protection used for?", listOf("Data encryption","Prevent unauthorized actions by logged-in user","Authentication","Routing"), "Prevent unauthorized actions by logged-in user"),
        MCQQuestion("What does a firewall do?", listOf("Blocks traffic based on rules","Encrypts files","Monitors logs","Scans viruses"), "Blocks traffic based on rules"),
        MCQQuestion("What is phishing?", listOf("Network scan","Social engineering attack to steal credentials","Firewall policy","Encryption"), "Social engineering attack to steal credentials"),
        MCQQuestion("Which is principle of least privilege?", listOf("Grant minimal permissions required","Grant full permissions","No permissions","Grant permissions later"), "Grant minimal permissions required"),
        MCQQuestion("What is a VPN used for?", listOf("Local storage","Secure remote network access","Faster CPU","Code repository"), "Secure remote network access"),
        MCQQuestion("What is a vulnerability scan?", listOf("Patch deployment","Scanning system for known vulnerabilities","Backups","Performance tuning"), "Scanning system for known vulnerabilities"),
        MCQQuestion("Which tool is used for network packet capture?", listOf("Wireshark","VSCode","Jenkins","Docker"), "Wireshark"),
        MCQQuestion("What is encryption?", listOf("Data compression","Transform data to unreadable form","User auth","OS process"), "Transform data to unreadable form"),
        MCQQuestion("Which is symmetric encryption?", listOf("RSA","AES","DSA","ECC"), "AES"),
        MCQQuestion("What is a DDoS attack?", listOf("Data corruption","Distributed denial of service","Database attack","Encryption attack"), "Distributed denial of service"),
        MCQQuestion("Which is a secure hashing algorithm?", listOf("MD5","SHA-256","ROT13","Base64"), "SHA-256"),
        MCQQuestion("What is a penetration test?", listOf("Performance test","Ethical hacking to find vulnerabilities","Unit test","Backup test"), "Ethical hacking to find vulnerabilities"),
        MCQQuestion("What are security patches for?", listOf("New features","Performance only","Fix vulnerabilities","UI changes"), "Fix vulnerabilities"),
        MCQQuestion("What is TLS/SSL used for?", listOf("Compression","Secure communications","Database","File transfer"), "Secure communications"),
        MCQQuestion("What is social engineering?", listOf("Programming technique","Manipulating people to disclose info","Network hack","Encryption"), "Manipulating people to disclose info"),
        MCQQuestion("What is role-based access control?", listOf("User-specific only","Permissions based on roles","No permission","Random assignment"), "Permissions based on roles"),
        MCQQuestion("What is a honeypot in security?", listOf("A trap to detect attacks","A secure store","A firewall","An encryption method"), "A trap to detect attacks"),
        MCQQuestion("What is multi-factor authentication?", listOf("Single password","Two or more authentication methods","No auth","CAPTCHA only"), "Two or more authentication methods"),
        MCQQuestion("Which is a common log monitoring tool?", listOf("Splunk","MySQL","Nginx","Redis"), "Splunk"),
        MCQQuestion("What is the purpose of a security policy?", listOf("Documents security rules and procedures","Test code","Design UI","Deploy apps"), "Documents security rules and procedures"),
        MCQQuestion("What is privilege escalation?", listOf("Reducing permissions","Gaining higher privileges than allowed","Normal login","Encryption"), "Gaining higher privileges than allowed"),
        MCQQuestion("What is a zero-day vulnerability?", listOf("Already patched","Unknown vulnerability with no patch","Old vulnerability","Testing method"), "Unknown vulnerability with no patch"),
        MCQQuestion("Which is secure coding practice?", listOf("Validate input","Trust all input","No logging","Hardcode creds"), "Validate input"),
        MCQQuestion("What is role of IDS?", listOf("All traffic routing","Detect potential intrusions","Database backup","Authentication"), "Detect potential intrusions"),
        MCQQuestion("Which technique protects stored passwords?", listOf("Plain text","Hashing with salt","Reversible encrypt","Base64"), "Hashing with salt")
    )

    private val secLong: List<LongQuestion> = listOf(
        LongQuestion("Explain the CIA triad and its importance.", listOf("confidentiality","integrity","availability")),
        LongQuestion("Describe common methods to prevent SQL injection.", listOf("prepared statements","parameterized","sanitize","escape")),
        LongQuestion("Explain how HTTPS secures web communication.", listOf("tls","ssl","certificate","encryption")),
        LongQuestion("Describe best practices for password storage.", listOf("hash","salt","bcrypt","argon2")),
        LongQuestion("Explain social engineering attacks and defenses.", listOf("phishing","awareness","training","policy")),
        LongQuestion("Describe how to perform a basic vulnerability assessment.", listOf("scan","enumerate","report","patch")),
        LongQuestion("Explain network segmentation and why it's useful.", listOf("segment","isolate","zones","limit")),
        LongQuestion("Describe how multi-factor authentication improves security.", listOf("mfa","token","sms","biometric")),
        LongQuestion("Explain role-based access control and its benefits.", listOf("roles","permissions","least privilege","policy")),
        LongQuestion("Describe how to secure APIs.", listOf("auth","rate limit","tls","validation")),
        LongQuestion("Explain DDoS attack types and mitigation strategies.", listOf("rate limit","cdn","scrubbing","filter")),
        LongQuestion("Describe incident response steps after breach.", listOf("identify","contain","eradicate","recover")),
        LongQuestion("Explain secure software development lifecycle (SDLC).", listOf("design","review","test","deploy")),
        LongQuestion("Describe common web vulnerabilities (OWASP Top 10).", listOf("xss","sqli","csrf","auth")),
        LongQuestion("Explain how to encrypt data at rest and in transit.", listOf("encryption","tls","disk","db")),
        LongQuestion("Describe how to perform secure code review.", listOf("patterns","sanitization","flows","logic")),
        LongQuestion("Explain the use of honeypots in detection.", listOf("trap","deception","monitor","attacker")),
        LongQuestion("Describe threat modeling basics.", listOf("assets","threats","mitigation","likelihood")),
        LongQuestion("Explain how to manage security patches.", listOf("inventory","test","deploy","verify")),
        LongQuestion("Describe endpoint security best practices.", listOf("anti-malware","patching","monitor","policy")),
        LongQuestion("Explain how to secure cloud resources.", listOf("iam","network","encryption","monitor")),
        LongQuestion("Describe how to create strong security policies.", listOf("scope","roles","enforce","review")),
        LongQuestion("Explain what a penetration test consists of.", listOf("recon","exploit","post-exploit","report")),
        LongQuestion("Describe methods for log aggregation and analysis.", listOf("splunk","elk","collect","alerts")),
        LongQuestion("Explain the importance of backups and disaster recovery.", listOf("backup","restore","rpo","rto")),
        LongQuestion("Describe privilege escalation and mitigation.", listOf("least privilege","monitor","patch","segmentation")),
        LongQuestion("Explain common authentication protocols (OAuth, SAML).", listOf("oauth","saml","token","assertion")),
        LongQuestion("Describe how container security differs from VM security.", listOf("isolation","images","runtime","namespaces")),
        LongQuestion("Explain secure deployment pipelines and CI/CD security.", listOf("secrets","signing","scanning","access")),
        LongQuestion("Discuss metrics and KPIs for security operations.", listOf("mttr","detections","alerts","incidents"))
    )

    // ------------ Helpers to return role lists ------------
    fun getRoleMCQs(role: String): List<MCQQuestion> = when (role) {
        "Android Developer" -> androidMCQs
        "Web Developer" -> webMCQs
        "Data Analyst" -> dataMCQs
        "AI Engineer" -> aiMCQs
        "Cybersecurity Specialist" -> secMCQs
        else -> androidMCQs
    }

    fun getRoleLongs(role: String): List<LongQuestion> {
        android.util.Log.d("DEBUG_ROLE", "Fetching longs for: $role")
        android.util.Log.d("DEBUG_ROLE", "webLong size: ${webLong.size}")
        android.util.Log.d("DEBUG_ROLE", "dataLong size: ${dataLong.size}")
        android.util.Log.d("DEBUG_ROLE", "aiLong size: ${aiLong.size}")
        android.util.Log.d("DEBUG_ROLE", "secLong size: ${secLong.size}")

        return when (role) {
            "Android Developer" -> androidLong
            "Web Developer" -> webLong
            "Data Analyst" -> dataLong
            "AI Engineer" -> aiLong
            "Cybersecurity Specialist" -> secLong
            else -> androidLong
        }
    }

}
