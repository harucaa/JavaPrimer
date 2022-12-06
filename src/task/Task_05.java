package task;

// 実技試験課題 Task #05 (2022-12-01)
//  #04の続き。
//  タブ区切りデータから情報を取り出し、インスタンスに収める
//  ArrayListとHashMapに収容し、
//  性別をラベル、GPAを特徴量とするlivSVM形式のフォーマットに変換する。
//  // TODO 実技試験課題 #05
//

//課題：「libSVM形式への変換」
//以下のJavaプログラムを作成せよ
//
//  準備：
//      配布したテキストファイル１つをダウンロードして保存する
//        -各行が、学生1名を表している(つもりと想定する)
//        -各行はタブ区切りで、学籍番号 性別 姓名 GPA となっている
//
//  (1) 学生一名分を表す新しいクラスを作成し
//    (1-1) 学籍番号 性別 姓名 GPA に対応する privateメンバー 変数を
//          それぞれ定義せよ
//    (1-2) (1-1)で定義したメンバー変数に代入して初期化するコンストラクタを作成せよ
//    (1-3) 各メンバーについてgetterとsetterを作成せよ
//
//  (2) 別のクラスにmainメソッドを定義して、
//      (2-1) その中で -ArrayListとHashMapを一つずつ定義して初期化せよ
//      (2-2) 保存したファイルを読み込み
//        (a) 1行ごとに、作成したクラスを new で初期化する
//              Stringクラスのインスタンスに対しsplit("\t")を呼び出せば、
//              タブ区切りの結果を配列で返してくれる
//        (b) 初期化したインスタンスをArrayListに追加する
//        (c) 行数をkey、初期化したインスタンスをvalueとしてHashMapに追加する
//      (2-3) LibSVM形式で出力し適当なファイルに保存せよ
//              特徴量としてGPAを、ラベルとして性別を出力すること
//              LibSVM形式はたとえば 11:87 2:0.5・・・ といった形
