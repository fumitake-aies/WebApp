CREATE TABLE IF NOT EXISTS memos (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- メモのID。自動インクリメントされ、一意の値が設定される
    content TEXT,                       -- メモの内容を格納
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 作成日時。デフォルトで現在のタイムスタンプが設定される
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- 更新日時。デフォルトで現在のタイムスタンプが設定され、更新時に自動的に現在のタイムスタンプに更新される
);

CREATE USER IF NOT EXISTS 'memo_user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'memo_user'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
