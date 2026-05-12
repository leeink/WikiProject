package com.example.wikiapp

import com.example.wikiapp.viewmodel.Article

val fakeArticles = listOf(
    Article(
        title = "The Rise of Jetpack Compose",
        author = "Alice Choi",
        content = "Jetpack Compose has fundamentally changed how Android developers build UIs. " +
                "With a declarative approach borrowed from frameworks like React and Flutter, " +
                "Compose allows developers to describe what the UI should look like, " +
                "rather than manually manipulating views. The result is less boilerplate, " +
                "more readable code, and faster iteration cycles.",
    ),
    Article(
        title = "Kotlin Coroutines Deep Dive",
        author = "Brian Park",
        content = "Coroutines are Kotlin's answer to asynchronous programming. " +
                "Unlike threads, coroutines are lightweight and can be suspended without blocking. " +
                "Understanding structured concurrency, scopes, and dispatchers " +
                "is key to writing safe and efficient async code in modern Android apps.",
    ),
    Article(
        title = "Understanding StateFlow vs SharedFlow",
        author = "Catherine Lee",
        content = "StateFlow and SharedFlow are hot flows in Kotlin that replace LiveData in " +
                "many modern Android architectures. StateFlow always holds a value and replays " +
                "it to new collectors, making it ideal for UI state. SharedFlow is more flexible " +
                "and suited for one-time events like navigation or error messages.",
    ),
    Article(
        title = "Building REST APIs with FastAPI",
        author = "David Kim",
        content = "FastAPI is a modern Python web framework that leverages type hints " +
                "to generate OpenAPI documentation automatically. Its async support and " +
                "Pydantic integration make it a top choice for building high-performance " +
                "APIs with minimal boilerplate and excellent developer ergonomics.",
    ),
    Article(
        title = "Introduction to Rust Ownership",
        author = "Ella Song",
        content = "Rust's ownership system is its most distinctive feature. " +
                "By enforcing strict rules about who owns data and when it's freed, " +
                "Rust eliminates entire classes of bugs at compile time — " +
                "including null pointer dereferences, use-after-free, and data races. " +
                "It takes time to internalize, but the payoff is rock-solid reliability.",
    ),
    Article(
        title = "ARCore and Jetpack Compose Integration",
        author = "Frank Yoon",
        content = "Combining ARCore with Jetpack Compose requires bridging the gap between " +
                "the traditional View system and the Compose world. Using AndroidView interop, " +
                "developers can embed ArFragment or a custom SurfaceView inside Compose layouts, " +
                "while managing ARCore session lifecycle carefully to avoid memory leaks.",
    ),
    Article(
        title = "On-Device ML with ONNX Runtime",
        author = "Grace Han",
        content = "ONNX Runtime enables running machine learning models directly on-device, " +
                "reducing latency and preserving user privacy. On Android, it pairs well with " +
                "YOLOv8 for real-time object detection tasks. Quantized models can run " +
                "efficiently even on mid-range hardware without GPU acceleration.",
    ),
    Article(
        title = "PostgreSQL Indexing Strategies",
        author = "Henry Jang",
        content = "Choosing the right index type in PostgreSQL can make or break query performance. " +
                "B-Tree indexes work for most equality and range queries, while GIN indexes " +
                "excel at full-text search and array containment. Understanding EXPLAIN ANALYZE " +
                "output is essential for diagnosing slow queries in production.",
    ),
    Article(
        title = "Next.js App Router Explained",
        author = "Irene Shin",
        content = "The Next.js App Router, introduced in version 13, brings React Server " +
                "Components to the forefront of full-stack web development. By colocating " +
                "server logic with UI components, it reduces client-side JavaScript bundles " +
                "and enables faster initial page loads, especially on data-heavy routes.",
    ),
    Article(
        title = "JWT Authentication Best Practices",
        author = "James Oh",
        content = "JSON Web Tokens are a popular choice for stateless authentication, " +
                "but they come with important caveats. Short-lived access tokens paired " +
                "with long-lived refresh tokens strike the right balance between security " +
                "and usability. Always store refresh tokens in HttpOnly cookies, " +
                "never in localStorage.",
    ),
    Article(
        title = "Exploring Union-Find for Graph Problems",
        author = "Karen Bae",
        content = "Union-Find, also known as Disjoint Set Union, is a foundational data structure " +
                "for solving connectivity problems in graphs. With path compression and " +
                "union by rank, both find and union operations run in near-constant time. " +
                "It's a must-know tool for competitive programming and system design interviews.",
    ),
    Article(
        title = "Docker Multi-Stage Builds",
        author = "Leo Moon",
        content = "Multi-stage Docker builds allow you to use one image for compiling or testing " +
                "and a separate, smaller image for the final artifact. This dramatically " +
                "reduces the size of production images by excluding build tools and " +
                "intermediate files that aren't needed at runtime.",
    ),
    Article(
        title = "Data Visualization with Chart.js",
        author = "Mia Cho",
        content = "Chart.js remains one of the most accessible charting libraries for the web. " +
                "Its canvas-based rendering keeps bundle sizes small, while the plugin system " +
                "allows deep customization. Pairing it with a backend that serves " +
                "aggregated data via REST makes for a clean, responsive analytics dashboard.",
    ),
    Article(
        title = "Spring Boot vs FastAPI: A Comparison",
        author = "Nathan Koo",
        content = "Spring Boot and FastAPI represent two distinct philosophies in backend development. " +
                "Spring Boot favors convention over configuration and shines in enterprise " +
                "environments with complex dependency injection needs. FastAPI, on the other hand, " +
                "prioritizes simplicity and performance, making it a natural fit for Python teams " +
                "building microservices or data-adjacent APIs.",
    ),
    Article(
        title = "Clean Architecture in Android",
        author = "Olivia Jung",
        content = "Clean Architecture separates an Android app into layers — presentation, " +
                "domain, and data — to keep business logic independent of frameworks and UI. " +
                "Use cases sit at the center and have no knowledge of Compose, Retrofit, or Room. " +
                "This separation makes code highly testable and resilient to technology changes over time.",
    ),
)