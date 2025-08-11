import React, { useState } from 'react';

function BookDetails({ book }) {
  return book ? (
    <div>
      <h3>Book Details</h3>
      <p>Title: {book.title}</p>
      <p>Author: {book.author}</p>
    </div>
  ) : null; // Conditional: Prevent rendering if no book
}

function BlogDetails({ blog }) {
  let content; // Element variable for conditional
  if (blog) {
    content = (
      <div>
        <h3>Blog Details</h3>
        <p>Title: {blog.title}</p>
        <p>Content: {blog.content}</p>
      </div>
    );
  } else {
    content = <p>No blog available.</p>;
  }
  return content;
}

function CourseDetails({ courses }) {
  return (
    <div>
      <h3>Course Details (List with Keys)</h3>
      <ul>
        {courses.map((course) => (
          <li key={course.id}> {/* Key for list items */}
            <p>Name: {course.name}</p>
            <p>Duration: {course.duration}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

function App() {
  const [showBook, setShowBook] = useState(true);
  const [showBlog, setShowBlog] = useState(true);

  const book = { title: 'React Basics', author: 'John Doe' };
  const blog = { title: 'Learning React', content: 'This is a blog on React.' };
  const courses = [
    { id: 1, name: 'Intro to JS', duration: '2 hours' },
    { id: 2, name: 'Advanced React', duration: '4 hours' }
  ];

  return (
    <div>
      <h1>Blogger App</h1>
      
      {/* Ternary conditional rendering */}
      {showBook ? <BookDetails book={book} /> : <p>Book details hidden.</p>}
      <button onClick={() => setShowBook(!showBook)}>Toggle Book</button>
      
      {/* Element variable conditional (already in component) */}
      <BlogDetails blog={showBlog ? blog : null} />
      <button onClick={() => setShowBlog(!showBlog)}>Toggle Blog</button>
      
      {/* Short-circuit conditional for list */}
      {courses.length > 0 && <CourseDetails courses={courses} />}
    </div>
  );
}

export default App;